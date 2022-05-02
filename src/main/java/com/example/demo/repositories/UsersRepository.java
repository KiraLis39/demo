package com.example.demo.repositories;

import com.example.demo.repositories.entities.Client;
import com.example.demo.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
