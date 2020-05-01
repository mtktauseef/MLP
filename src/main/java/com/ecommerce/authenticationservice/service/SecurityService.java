package com.ecommerce.authenticationservice.service;

import org.springframework.stereotype.Service;

/*
 * @Author TechMtk
 * created on 4/10/2020
 */

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}