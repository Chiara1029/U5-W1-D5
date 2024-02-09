package it.chiarapuleio.resmanagement.resmanagement.services;

import it.chiarapuleio.resmanagement.resmanagement.dao.BuildingDAO;
import it.chiarapuleio.resmanagement.resmanagement.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    @Autowired
    private BuildingDAO buildingDAO;

    public void save(Building building){
        buildingDAO.save(building);
        System.out.println("Building saved.");
    }

    public Building findById(long buildingId){
        Optional<Building> found = buildingDAO.findById(buildingId);
        return found.get();
    }

    public List<Building> findAll(){
        return buildingDAO.findAll();
    }

    public void findByIdAndUpdate(long buildingId, Building updatedBuilding){
        Building found = this.findById(buildingId);
        found.setAddress(updatedBuilding.getAddress());
        found.setCity(updatedBuilding.getCity());
        found.setName(updatedBuilding.getName());
        buildingDAO.save(found);
        System.out.println("Building updated.");
    }

    public void findByIdAndDelete(long buildingId){
        Building found = this.findById(buildingId);
        buildingDAO.delete(found);
        System.out.println("Building deleted.");
    }
}
