package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDAO extends JpaRepository<Building, Long> {
}
