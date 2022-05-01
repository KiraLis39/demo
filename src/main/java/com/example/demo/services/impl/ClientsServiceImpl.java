package com.example.demo.services.impl;

import com.example.demo.repositories.ClientsRepository;
import com.example.demo.repositories.entities.Client;
import com.example.demo.services.ClientsService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Сервис клиентов
 */
@Service
@Validated
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    private final ClientsRepository clientsRepository;

    @Override
    public Optional<Client> findById(Long id) {
        return clientsRepository.findById(id);
    }

    @Override
    public Optional<Client> findByName(String name) {
        return clientsRepository.findByName(name);
    }

    @Override
    public Page<Client> findAll(int pageIndex, int pageSize) {
        return clientsRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public void save(@Valid Client client) {
        clientsRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        clientsRepository.deleteById(id);
    }
}
