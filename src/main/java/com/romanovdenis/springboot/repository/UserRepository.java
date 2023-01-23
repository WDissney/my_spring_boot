package com.romanovdenis.springboot.repository;

import com.romanovdenis.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
