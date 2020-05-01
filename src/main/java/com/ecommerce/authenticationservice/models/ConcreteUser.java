package com.ecommerce.authenticationservice.models;

import javax.persistence.*;
import java.util.Set;

/*
 * @Author TechMtk
 * created on 4/13/2020
 */

//@Entity
//@Table(name = "username")
public class ConcreteUser {
   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String username;
    private final String password;

    //@Transient
    private final String passwordConfirm;

    //@ManyToMany
    private final Set<Role> roles;

    //Only Getter in this Class
    // Initializing Constructer

    public ConcreteUser(Long id, String username, String password,String passwordConfirm,Set<Role>  roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm(){
        return passwordConfirm;
    }
    public Set<Role> getRoles() {
        return roles;
    }

     ///@Entity
    public static class UserBuilder{
        private Long id;
        private String username;
        private String password;

       // @ManyToMany
        private Set<Role> roles;

       // @Transient
        private String passwordConfirm;

        // Only Setter in this class
        public UserBuilder id(Long id){
            this.id =id;
            return this;
        }
        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
            return this;
        }

        public UserBuilder setRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public ConcreteUser build(){
            return new ConcreteUser(id,username,password, passwordConfirm,roles);
        }
    }
}
