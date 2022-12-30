package com.springBootDemo.springbootdemoall.controller;

import com.springBootDemo.springbootdemoall.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class HomePageController {

    @RequestMapping("/")
    public String showHomePage(Model model){
        User user = (User) model.getAttribute("user");

        if (user != null && user.getFirstName() != null && user.getLoginCount() == 1){
            model.addAttribute("flag","added");
            model.addAttribute("message", user.getFirstName()+ " have been registered");
        }
        return "home-page";
    }
}
