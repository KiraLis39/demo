package com.example.demo.controllers;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.OperationFailedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.entities.Client;
import com.example.demo.repositories.entities.Order;
import com.example.demo.repositories.entities.User;
import com.example.demo.security.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersServiceImpl usersService;

    @GetMapping("/{id}")
    @ResponseBody
    public UserDTO findById(@PathVariable Long id) {
        return new UserDTO(usersService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id)));
    }

    @GetMapping
    @ResponseBody
    public Page<UserDTO> findAll(@RequestParam(defaultValue = "0", name = "p") int pageIndex) {
        return usersService.findAll(pageIndex, 10).map(UserDTO::new);
    }

    @PostMapping
    @ResponseBody
    public void save(@RequestBody User user) {
        usersService.save(user);
    }

    @PutMapping
    @ResponseBody
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") User user) {
        usersService.deleteById(user.getId());
    }
}
