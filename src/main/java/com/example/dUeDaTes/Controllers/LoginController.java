package com.example.dUeDaTes.Controllers;

import com.example.dUeDaTes.Models.Forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class LoginController{
    //to get login form page
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String getLoginForm() {
        //return html page name
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
    //if username and password are correct, return to the home page
        if("studentID@dadeschools.net".equals(username) && "organized1234".equals(password)){
            return "home";
        }
        //if username or password is wrong
        model.addAttribute("invalidCredentials", true);
        //return again login page
        return "login";
    }
}
