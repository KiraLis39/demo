package com.example.demo.services;

import com.example.demo.repositories.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

public interface ClientsService {
    Optional<Client> findById(Long id);

    Optional<Client> findByName(String name);

    Page<Client> findAll(int pageIndex, int pageSize);
    void save(Client client);

    void deleteById(Long id);
}
