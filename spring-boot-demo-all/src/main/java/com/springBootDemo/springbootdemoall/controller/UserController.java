package com.springBootDemo.springbootdemoall.controller;

import com.springBootDemo.springbootdemoall.entity.User;
import com.springBootDemo.springbootdemoall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login-page")
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login-page";
    }

    @PostMapping("/process-login-page")
    public String showPersonalLibrary(@ModelAttribute("user") User user, Model model){
        User tempUser = userService.findByFirstNameAndPassword(user.getFirstName(), user.getPassword());
        if (tempUser != null) {
            if (tempUser.getLoginCount() < 2) tempUser.setLoginCount(tempUser.getLoginCount()+1);
            tempUser.setLoginStatus(1);
            userService.saveUser(tempUser);
//            tempUser = userService.findById(tempUser.getId());
            model.addAttribute("user", tempUser);
            return "redirect:/library/personal-collection";
        }
        else {
            model.addAttribute("flag", "invalid");
            model.addAttribute("message", "invalid username & password");
            return "redirect:/user/login-page";
        }
    }

    @GetMapping("/registration-page")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration-page";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model){

        if(result.hasErrors()){
            return "registration-page";
        }
        else {
            user.setLoginCount(1);
            userService.addOrUpdateUser(user);
            model.addAttribute("user",
                    userService.findByFirstNameAndPassword(user.getFirstName(), user.getPassword()));
            return "redirect:/";
        }
    }
}
