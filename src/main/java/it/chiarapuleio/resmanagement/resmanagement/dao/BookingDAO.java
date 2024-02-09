package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long> {
}
