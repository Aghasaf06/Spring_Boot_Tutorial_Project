package springtutorial.business.abstracts;

import springtutorial.core.entities.User;
import springtutorial.core.utilities.results.DataResult;
import springtutorial.core.utilities.results.Result;

public interface UserService {

    Result add(User user);

    DataResult<User> findByEmail(String email);
}
