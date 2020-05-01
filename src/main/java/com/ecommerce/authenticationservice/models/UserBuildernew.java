package com.ecommerce.authenticationservice.models;

import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

/*
 * @Author TechMtk
 * created on 4/13/2020
 */
public class UserBuildernew {
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    private Set<Role> roles;

    @Transient
    private String passwordConfirm;

    // Only Setter in this class
    public UserBuildernew id(Long id){
        this.id =id;
        return this;
    }
    public UserBuildernew setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuildernew setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuildernew setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
        return this;
    }

    public UserBuildernew setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public ConcreteUser build(){
        return new ConcreteUser(id,username,password, passwordConfirm,roles);
    }
//    // Returning the Constructed Object
//    public ConcreteUser build(){
//        ConcreteUser user = new ConcreteUser(this);
//        return user;
//    }

}
