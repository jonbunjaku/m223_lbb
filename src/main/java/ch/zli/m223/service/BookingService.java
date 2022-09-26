package ch.zli.m223.service;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.xml.sax.EntityResolver;

import ch.zli.m223.model.Booking;

public class BookingService {
    @Inject
    private EntityManager entityManager;

/*     public List<Booking> findBookingsByUserId(Long id) {
        var booking = entityManager.find(Booking.class, id);
        return ;
    } */


    public List<Booking> findAll() {
        var bookings = entityManager.createQuery("FROM Booking", Booking.class );
        return bookings.getResultList();
    }

    @Transactional
    public void deleteBooking(Long id) {
        var booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }

    @Transactional
    public Booking updateBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }
}
