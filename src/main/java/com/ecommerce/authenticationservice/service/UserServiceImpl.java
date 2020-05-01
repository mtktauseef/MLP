package com.ecommerce.authenticationservice.service;

import com.ecommerce.authenticationservice.models.ConcreteUser;
import com.ecommerce.authenticationservice.models.User;
import com.ecommerce.authenticationservice.repo.RoleRepository;
import com.ecommerce.authenticationservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
/*
 * @Author TechMtk
 * created on 4/10/2020
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    // Swicth here
//    public void save(ConcreteUser.UserBuilder user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.build().getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
//        userRepository.save(user);
//    }
//
//    @Override
//    public ConcreteUser.UserBuilder findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
