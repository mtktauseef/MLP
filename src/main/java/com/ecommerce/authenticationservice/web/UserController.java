package com.ecommerce.authenticationservice.web;

/*
 * @Author TechMtk
 * created on 4/10/2020
 */
import com.ecommerce.authenticationservice.models.ConcreteUser;
import com.ecommerce.authenticationservice.models.User;
import com.ecommerce.authenticationservice.service.SecurityService;
import com.ecommerce.authenticationservice.service.UserService;
import com.ecommerce.authenticationservice.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

//    @Value("${authentication-service.redirect.url}")
//    private String redirectURL;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    //Switch Here
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        // and Here replace build().
        userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        // return "redirect:/login";
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
//        return "redirect:" + redirectURL;
        return "welcome";
    }
}
