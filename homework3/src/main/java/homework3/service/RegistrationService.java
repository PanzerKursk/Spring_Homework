package homework3.service;


import homework3.model.User;
import homework3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    @Autowired
    private User user;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age,email);

        userRepository.saveUser(newUser);
        notificationService.displayMessage("Успешно создан новый пользователь");
    }
}
