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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

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
        bookingSrv.save((Booking) ctx.getBean("book1"));
        bookingSrv.save((Booking) ctx.getBean("book2"));
    }
}
