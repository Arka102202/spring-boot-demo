package com.springBootDemo.springbootdemoall.controller;


import com.springBootDemo.springbootdemoall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/library")
public class LibraryController {


    @Autowired
    private UserController userController;

    @RequestMapping("/personal-collection")
    public String showPersonalLibrary(Model model) {
        User user = (User) model.getAttribute("user");

        if (user == null || user.getLoginStatus() == 0) return "redirect:/user/login-page";
        else return "/personal-library";

    }

}
