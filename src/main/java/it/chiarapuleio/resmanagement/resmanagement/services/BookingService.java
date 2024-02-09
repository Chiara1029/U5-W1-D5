package it.chiarapuleio.resmanagement.resmanagement.services;

import it.chiarapuleio.resmanagement.resmanagement.dao.BookingDAO;
import it.chiarapuleio.resmanagement.resmanagement.entities.Booking;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingDAO bookingDAO;

    public void save(Booking book){
        bookingDAO.save(book);
        System.out.println("Booking saved.");
    }

    public Booking findById(long bookId){
        Optional<Booking> found = bookingDAO.findById(bookId);
        return found.get();
    }

    public List<Booking> findAll(){
        return bookingDAO.findAll();
    }

    public void findByIdAndUpdate(long bookId, Booking updatedBook){
        Booking found = this.findById(bookId);
        found.setBookedDate(updatedBook.getBookedDate());
        found.setWorkstation(updatedBook.getWorkstation());
        found.setUser(updatedBook.getUser());
        bookingDAO.save(updatedBook);
        System.out.println("Book updated.");
    }

    public void findByIdAndDelete(long bookId){
        Booking found = this.findById(bookId);
        bookingDAO.delete(found);
        System.out.println("Book deleted.");
    }

    public long getMaxUsers(Workstation workstation, LocalDate bookedDate){
        return bookingDAO.countByWorkstationAndBookedDate(workstation, bookedDate);
    }
}
