package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation,Long> {
}
