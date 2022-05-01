package com.example.demo.repositories;

import com.example.demo.repositories.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
