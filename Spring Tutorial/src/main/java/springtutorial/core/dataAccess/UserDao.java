package springtutorial.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import springtutorial.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
