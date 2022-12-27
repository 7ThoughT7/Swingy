package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findUserById(Integer id);
}
