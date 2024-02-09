package it.chiarapuleio.resmanagement.resmanagement;

import it.chiarapuleio.resmanagement.resmanagement.entities.Booking;
import it.chiarapuleio.resmanagement.resmanagement.entities.Building;
import it.chiarapuleio.resmanagement.resmanagement.entities.User;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import it.chiarapuleio.resmanagement.resmanagement.services.BookingService;
import it.chiarapuleio.resmanagement.resmanagement.services.BuildingService;
import it.chiarapuleio.resmanagement.resmanagement.services.UserService;
import it.chiarapuleio.resmanagement.resmanagement.services.WorkStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private AnnotationConfigApplicationContext ctx;
    @Autowired
    BuildingService buildingSrv;
    @Autowired
    WorkStationService workStationSrv;
    @Autowired
    UserService userSrv;
    @Autowired
    BookingService bookingSrv;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("----- SAVE BUILDINGS -----");
        buildingSrv.save((Building) ctx.getBean("building1"));
        buildingSrv.save((Building) ctx.getBean("building2"));
        buildingSrv.save((Building) ctx.getBean("building3"));
        System.out.println("----- SAVE WORKSPACES -----");
        workStationSrv.save((Workstation) ctx.getBean("workstation1"));
        workStationSrv.save((Workstation) ctx.getBean("workstation2"));
        workStationSrv.save((Workstation) ctx.getBean("workstation3"));
        workStationSrv.save((Workstation) ctx.getBean("workstation4"));
        workStationSrv.save((Workstation) ctx.getBean("workstation5"));
        workStationSrv.save((Workstation) ctx.getBean("workstation6"));
        System.out.println("----- SAVE USERS -----");
        userSrv.save((User) ctx.getBean("user1"));
        userSrv.save((User) ctx.getBean("user2"));
        userSrv.save((User) ctx.getBean("user3"));
        System.out.println("----- SAVE BOOKINGS -----");
        //per evitare che la lista di prenotazioni sia null in partenza, ho effettuato il primo save/add senza particolari vincoli
        bookingSrv.save((Booking) ctx.getBean("book2"));
        Booking booked = (Booking) ctx.getBean("book2");
        booked.getWorkstation().getBookingStationList().add(booked);


        //dal secondo save/add è necessario verificare una serie di condizioni prima di procedere
        try {
            Booking booking = (Booking) ctx.getBean("book1");
            List<Booking> bookingList = booking.getWorkstation().getBookingStationList();
            LocalDate bookedDate = booking.getBookedDate();
            //isBookable confronta le date delle prenotazioni già presenti per una postazione
            //maxUsers serve per verificare il limite di posti disponibili confrontandoli con il limite della postazione inserita
            boolean isBookable = booking.getWorkstation().getBookingStationList().stream().noneMatch(book -> book.getBookedDate().isEqual(bookedDate));
            long maxUsers = bookingSrv.getMaxUsers(booking.getWorkstation(), bookedDate);
            if (isBookable) {
                if (maxUsers < booking.getWorkstation().getMaxUsers()) {
                    booking.getWorkstation().setFree(false);
                    bookingSrv.save(booking);
                } else {
                    throw new IllegalStateException("There's no room for you on this day. Please try another date or workstation.");
                }
            } else {
                throw new IllegalStateException("There's no room for you on this day. Please try another date or workstation.");
            }
            //se, al termine di questi "controlli" risulta tutto true, allora la nuova prenotazione verrà aggiunta alla lista delle prenotazioni della postazione
            bookingList.add(booking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
