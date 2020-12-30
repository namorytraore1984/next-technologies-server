package com.nexttechnologies.nexttechnologiesserver.repositories;

import com.nexttechnologies.nexttechnologiesserver.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
