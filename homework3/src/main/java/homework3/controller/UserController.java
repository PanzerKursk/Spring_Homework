package homework3.controller;

import homework3.model.User;
import homework3.repository.UserRepository;
import homework3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList(){
        return userRepository.getAllUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "Пользователь создан из тела";
    }

}
