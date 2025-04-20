package homework3.controller;

import homework3.model.User;
import homework3.repository.UserRepository;
import homework3.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataService dataService;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return dataService.sortUsersByAge(userRepository.getAllUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return dataService.filterUsersByAge(userRepository.getAllUsers(),age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge(){
        return dataService.calculateAverageAge(userRepository.getAllUsers());
    }
}
