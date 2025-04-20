package homework3.repository;

import homework3.model.User;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void saveUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }
}
