package ch.zli.m223.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Bookingstatus;
import ch.zli.m223.service.BookingService;

@Path("/api/bookings")
public class BookingController {
    
    @Inject
    BookingService bookingService;

    @GET
    @RolesAllowed("admin")
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    public List<Booking> index() {
        return bookingService.findAll();
    }

    @GET
    @Path("/get/{id}")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Booking> getBookingsByUserId(@PathParam("id") Long id) {
        return bookingService.findBookingsByUserId(id);
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RequestScoped
    public void deleteBooking(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @PUT
    @RolesAllowed("admin")
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    public Booking updateBooking(Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @PUT
    @RolesAllowed("admin")
    @Path("putStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequestScoped
    public Bookingstatus updateBookingstatus(Bookingstatus bookingstatus) {
        return bookingService.updateBookingStatus(bookingstatus);
    }
    
}
