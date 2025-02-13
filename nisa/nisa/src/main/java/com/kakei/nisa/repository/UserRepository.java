package com.kakei.nisa.repository;

import com.kakei.nisa.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
