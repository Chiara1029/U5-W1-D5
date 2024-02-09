package it.chiarapuleio.resmanagement.resmanagement.services;

import it.chiarapuleio.resmanagement.resmanagement.dao.UserDAO;
import it.chiarapuleio.resmanagement.resmanagement.entities.User;
import it.chiarapuleio.resmanagement.resmanagement.entities.Workstation;
import it.chiarapuleio.resmanagement.resmanagement.enums.StationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void save(User user){
        userDAO.save(user);
        System.out.println("User saved.");
    }

    public User findById(long userId){
        Optional<User> found = userDAO.findById(userId);
        return found.get();
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public void findByIdAndUpdate(long userId, User updatedUser){
        User found = this.findById(userId);
        found.setName(updatedUser.getName());
        found.setSurname(updatedUser.getSurname());
        found.setEmail(updatedUser.getEmail());
        found.setUsername(updatedUser.getUsername());
        userDAO.save(found);
        System.out.println("User updated.");
    }

    public void findByIdAndDelete(long userId){
        User found = this.findById(userId);
        userDAO.delete(found);
        System.out.println("User deleted.");
    }

    public List<Workstation> findWorkstationByTypeAndCity(StationType stationType, String city){
        return userDAO.findWorkstationByTypeAndCity(stationType, city);
    }
}
