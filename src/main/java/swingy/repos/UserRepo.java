package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
