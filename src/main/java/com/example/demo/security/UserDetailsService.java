package com.example.demo.security;

import com.example.demo.repositories.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserDetailsService {
    Optional<User> findById(Long id);
    Optional<User> findByName(String string);
    Page<User> findAll(int pageIndex, int pageSize);
    void save(User user);
    void deleteById(Long id);
}
