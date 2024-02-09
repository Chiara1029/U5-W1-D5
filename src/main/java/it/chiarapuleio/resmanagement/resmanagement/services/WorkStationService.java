package it.chiarapuleio.resmanagement.resmanagement.services;

import it.chiarapuleio.resmanagement.resmanagement.dao.WorkstationDAO;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkStationService {
    @Autowired
    private WorkstationDAO workstationDAO;

    public void save(Workstation workstation){
        workstationDAO.save(workstation);
        System.out.println("Workstation saved.");
    }

    public Workstation findById(long workstationId){
        Optional<Workstation> found = workstationDAO.findById(workstationId);
        return found.get();
    }

    public List<Workstation> findAll(){
        return workstationDAO.findAll();
    }

    public void findByIdAndUpdate(long workstationId, Workstation updatedWorkstation){
        Workstation found = this.findById(workstationId);
        found.setBuilding(updatedWorkstation.getBuilding());
        found.setDescription(updatedWorkstation.getDescription());
        found.setStationType(updatedWorkstation.getStationType());
        found.setMaxUsers(updatedWorkstation.getMaxUsers());
        workstationDAO.save(found);
        System.out.println("Workstation updated.");
    }

    public void findByIdAndDelete(long workstationId){
        Workstation found = this.findById(workstationId);
        workstationDAO.delete(found);
        System.out.println("Workstation deleted.");
    }
}
