package ch.zli.m223.exception;

public class BookingExistsException extends RuntimeException {
    public BookingExistsException(String message) {
        super(message);
    }
}