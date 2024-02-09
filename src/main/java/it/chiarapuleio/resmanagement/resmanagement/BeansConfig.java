package it.chiarapuleio.resmanagement.resmanagement;


import com.github.javafaker.Faker;
import it.chiarapuleio.resmanagement.resmanagement.dao.BookingDAO;
import it.chiarapuleio.resmanagement.resmanagement.entities.Booking;
import it.chiarapuleio.resmanagement.resmanagement.entities.Building;
import it.chiarapuleio.resmanagement.resmanagement.entities.User;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import it.chiarapuleio.resmanagement.resmanagement.enums.StationType;
import it.chiarapuleio.resmanagement.resmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Locale;

@Configuration
public class BeansConfig {
    Faker faker = new Faker(Locale.ENGLISH);
    @Autowired
    BookingService bookingSrv;

    // BUILDINGS
    @Bean
    Building building1() {
        return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());
    }

    @Bean
    Building building2() {
        return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());
    }

    @Bean
    Building building3() {
        return new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());
    }

    // WORKSTATION
    @Bean
    Workstation workstation1() {
        return new Workstation("single desk for lonelier", StationType.PRIVATE, 1, building1());
    }

    @Bean
    Workstation workstation2() {
        return new Workstation("multiple desk to improve co-working", StationType.OPENSPACE, faker.number().numberBetween(1, 5), building1());
    }

    @Bean
    Workstation workstation3() {
        return new Workstation("unique desk = all for one, one for all", StationType.MEETING_ROOM, faker.number().numberBetween(1, 10), building1());
    }

    @Bean
    Workstation workstation4() {
        return new Workstation("single desk with coffee machine", StationType.PRIVATE, 1, building2());
    }

    @Bean
    Workstation workstation5() {
        return new Workstation("double desk for teams", StationType.OPENSPACE, faker.number().numberBetween(1, 4), building2());
    }

    @Bean
    Workstation workstation6() {
        return new Workstation("we don't have enough fantasy to write a fancy description", StationType.MEETING_ROOM, faker.number().numberBetween(1, 10), building3());
    }


//    static StationType getRandomStationType() {
//        StationType[] options = StationType.values();
//        int indexRand = new Random().nextInt(options.length);
//        return options[indexRand];
//    }

    // USER
    @Bean
    User user1() {
        return new User(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    User user2() {
        return new User(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    User user3() {
        return new User(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
    }

    // BOOKING
    @Bean
    Booking book1() {
        return new Booking(user1(), LocalDate.of(2024, 1, 15), workstation1());
    }
    @Bean
    Booking book2() {
        return new Booking(user2(), LocalDate.of(2024, 1, 15), workstation1());
    }
}
