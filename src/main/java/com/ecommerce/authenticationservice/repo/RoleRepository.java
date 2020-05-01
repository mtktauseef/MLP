package com.ecommerce.authenticationservice.repo;

import com.ecommerce.authenticationservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
