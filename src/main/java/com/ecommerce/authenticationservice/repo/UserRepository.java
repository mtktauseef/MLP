package com.ecommerce.authenticationservice.repo;


import com.ecommerce.authenticationservice.models.ConcreteUser;
import com.ecommerce.authenticationservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Change below to switch between models and BuilderPattern
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
  //  ConcreteUser.UserBuilder findByUsername(String username);
}
