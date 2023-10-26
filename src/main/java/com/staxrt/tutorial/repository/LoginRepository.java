package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
