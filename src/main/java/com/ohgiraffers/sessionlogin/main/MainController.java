package com.ohgiraffers.sessionlogin.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class MainController {
    @GetMapping(value ={"/","/main"})
    public String defaultLocation() {
        return "main/main";}

        @PostMapping("/")
        public String redirectMain() {
            return "redirect:/";


        }
    }

