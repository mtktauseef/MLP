package com.ecommerce.authenticationservice.validator;

/*
 * @Author TechMtk
 * created on 4/10/2020
 */
import com.ecommerce.authenticationservice.models.ConcreteUser;
import com.ecommerce.authenticationservice.models.User;
import com.ecommerce.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        // Switch Here
       // return ConcreteUser.UserBuilder.class.equals(aClass);
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
      //  ConcreteUser.UserBuilder user = (ConcreteUser.UserBuilder) o;
        User user = (User) o;

        //And Here replace all 'build().' with Blank

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}