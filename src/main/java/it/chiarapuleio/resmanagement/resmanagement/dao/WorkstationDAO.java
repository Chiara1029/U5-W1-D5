package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import it.chiarapuleio.resmanagement.resmanagement.enums.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation,Long> {
    @Query("SELECT w FROM Workstation w JOIN w.building b WHERE w.stationType=:stationType AND b.city=:city")
    List<Workstation> findWorkstationByTypeAndCity(StationType stationType, String city);
}
