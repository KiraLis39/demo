package com.example.demo.services;

import com.example.demo.repositories.entities.User;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface UsersService {
    Optional<User> findById(Long id);
    Page<User> findAll(int pageIndex, int pageSize);
    void save(User user);
    void deleteById(Long id);
}
