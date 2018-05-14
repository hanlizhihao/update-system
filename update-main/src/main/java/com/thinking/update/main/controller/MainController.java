package com.thinking.update.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getMain() {
        return "index";
    }
}
