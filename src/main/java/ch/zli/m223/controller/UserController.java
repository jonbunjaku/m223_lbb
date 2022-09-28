package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.User;
import ch.zli.m223.service.BookingService;
import ch.zli.m223.service.UserService;

@Path("/api/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("/getAll")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    
    @DELETE
    @RolesAllowed("admin")
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RequestScoped
    public void deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

    @GET
    @Path("/get/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @POST
    @Path("/create")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @PUT
    @Path("/put/{id}")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

}
