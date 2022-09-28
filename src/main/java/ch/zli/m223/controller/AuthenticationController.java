package ch.zli.m223.controller;

import java.io.IOException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse.StatusCode;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;
import io.smallrye.jwt.build.Jwt;

@Path("/auth")
@Tag(name = "Authentication", description = "Handling of login and registration")
public class AuthenticationController {
    @Inject
    UserService userService;
    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/login/{email}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Is responsible for the login into the system.", description = "Tries to authenticate the user with the provided email and designated password.")
    public String login(@PathParam("email") String emailInput, @PathParam("password") String passwordInput)
            throws IOException {
        try {
            // Veilleicht noch so umbauen, dass im body die Parameter mitgegeben werden ?
            if (!emailInput.contains("@")) {
                throw new IllegalArgumentException("Wrong e-mail format!");
            }
            // Try to get the member of the database by providing the eMail and password as
            // parameter
            var user = userService.getUserByEmailAndPassword(emailInput, passwordInput);
            // Check what role is assigned to the member
            String groupSelection = "";
            if (user.getIsAdmin()) {
                groupSelection = "admin";
            } else if (!user.getIsAdmin()) {
                groupSelection = "normalUser";
            }
            // Generate the JWT
            String token = Jwt.issuer("https://example.com/issuer")
                    .upn(user.getEmail())
                    .groups(groupSelection)
                    .expiresIn(86400)
                    .sign();
            return token;
        } catch (Exception e) {
            // Make some error handeling
            return e.getMessage();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Is responsible for the registration of a new member.", description = "Tries to create a member and also authenticate the user with the provided email and password.")
    public String register(User user) throws IOException {
        try {
            if (!user.getEmail().contains("@")) {
                throw new IllegalArgumentException("The e-mail needs the '@' sign!");
            }
            user.setIsAdmin(false);
            userService.createUser(user);
            return login(user.getEmail(), user.getPasswort());
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}