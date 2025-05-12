package ru.davydchenkov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

        @GetMapping("/home")
        public String home(){
            return "home";
        }

        @GetMapping("/login")
        public String auth(){
            return "login";
        }

        @GetMapping("/public-data")
        public String user(){
            return "public-data";
        }
        @GetMapping("/private-data")
        public String admin(){
            return "private-data";
        }
}
