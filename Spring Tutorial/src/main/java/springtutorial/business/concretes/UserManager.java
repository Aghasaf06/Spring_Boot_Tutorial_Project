package springtutorial.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial.business.abstracts.UserService;
import springtutorial.core.dataAccess.UserDao;
import springtutorial.core.entities.User;
import springtutorial.core.utilities.results.DataResult;
import springtutorial.core.utilities.results.Result;
import springtutorial.core.utilities.results.SuccessDataResult;
import springtutorial.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added!");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Users listed!");
    }
}
