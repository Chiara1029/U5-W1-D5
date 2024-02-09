package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.Booking;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long> {
    long countByWorkstationAndBookedDate(Workstation workstation, LocalDate bookedDate);
}
