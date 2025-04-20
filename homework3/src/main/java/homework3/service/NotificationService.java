package homework3.service;

import homework3.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void userCreationNotification(User user){
        System.out.println("Создан новый пользователь " + user.getName());
    }

    public void displayMessage(String str){
        System.out.println(str);
    }

}
