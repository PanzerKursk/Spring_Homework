package homework3.service;

import homework3.model.User;
import homework3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;


@Service
public class DataService {
    @Autowired
    private UserRepository userRepository;

    public List<User> sortUsersByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(User::getAge)).toList();
    }

    public List<User> filterUsersByAge(List<User> users, int age){
        return users.stream().filter(user -> user.getAge() >= age).toList();
    }

    public double calculateAverageAge(List<User> users){
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }
}
