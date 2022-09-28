package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Workspace;
import ch.zli.m223.service.WorkspaceService;

@Path("/api/workspaces")
public class WorkspaceController {

    @Inject
    WorkspaceService workspaceService;

    @GET
    @Path("/getAll")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    public List<Workspace> index() {
        return workspaceService.getAllWorkspaces();
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RequestScoped
    public void deleteUser(@PathParam("id") Long id) {
        workspaceService.deleteWorkspace(id);
    }

    @POST
    @RolesAllowed("admin")
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Workspace createWorkspace(Workspace workspace) {
        return workspaceService.createWorkspace(workspace);
    }

    @GET
    @Path("/getAll/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Workspace getWorkspaceById(@PathParam("id") Long id) {
        return workspaceService.getWorkspaceById(id);
    }
    @PUT
    @Path("/put/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Workspace updateWorkspace(Workspace workspace) {
        return workspaceService.updateWorkspace(workspace);
    }
}
