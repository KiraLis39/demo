package com.example.demo.services.impl;

import com.example.demo.repositories.UsersRepository;
import com.example.demo.repositories.entities.User;
import com.example.demo.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис пользователей
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Page<User> findAll(int pageIndex, int pageSize) {
        return usersRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public void save(User order) {
        usersRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }
}
