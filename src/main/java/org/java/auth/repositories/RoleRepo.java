package org.java.auth.repositories;


import org.java.auth.POJO.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
