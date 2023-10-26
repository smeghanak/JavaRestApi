package com.staxrt.tutorial.repository;


import com.staxrt.tutorial.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
