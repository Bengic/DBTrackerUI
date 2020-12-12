package com.DBTracker.DBTracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Welcome {
    @RequestMapping("/home")
public String welcome(){return "hi";}
}
