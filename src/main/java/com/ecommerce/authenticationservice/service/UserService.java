package com.ecommerce.authenticationservice.service;
/*
 * @Author TechMtk
 * created on 4/10/2020
 */

import com.ecommerce.authenticationservice.models.ConcreteUser;
import com.ecommerce.authenticationservice.models.User;

public interface UserService {

    // Switch here between patterns
    void save(User user);
   // void  save (ConcreteUser.UserBuilder userBuilder);
    // Switch here between patterns
   User findByUsername(String username);
   // ConcreteUser.UserBuilder findByUsername(String username);
}
