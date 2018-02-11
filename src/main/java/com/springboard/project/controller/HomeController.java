package com.springboard.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home","/index","/"})
public class HomeController {

    @Autowired String homeView;

    @GetMapping
    public String home(){
        return this.homeView;
    }
}
