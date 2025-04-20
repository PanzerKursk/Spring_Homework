package homework4.controller;

import homework4.model.Info;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/homepage")
public class PageController {

    @GetMapping
    public String home(Model model) {
        String message1 = "Для просмотра данных перейдите по адресу: http://localhost:8080/homepage/data";
        String message2 = "Для ввода данных перейдите по адресу: http://localhost:8080/homepage/newdata";
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        return "homepage";
    }

    @GetMapping("/data")
    public String data(Model model) {
        model.addAttribute("name", "Имя");
        model.addAttribute("lastName", "Фамилия");
        return "datapage";
    }

    @GetMapping("/newdata")
    public String form(Model model) {
        model.addAttribute("input", new Info());
        return "newdata";
    }

    @PostMapping("/newdata")
    public String result(Info info, Model model) {
        model.addAttribute("input", info.getInput());
        //model.addAttribute("input2", info.getInput2());
        return "resultpage";
    }
}

