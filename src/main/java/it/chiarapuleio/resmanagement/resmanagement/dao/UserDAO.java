package it.chiarapuleio.resmanagement.resmanagement.dao;

import it.chiarapuleio.resmanagement.resmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
