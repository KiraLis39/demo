package com.example.demo.controllers;

import com.example.demo.dto.ClientDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.entities.Client;
import com.example.demo.services.impl.ClientsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientsController {
    private final ClientsServiceImpl clientsService;

    /**
     * Список всех клиентов.
     *
     * @return список клиентов.
     */
    @GetMapping("/data")
    @ResponseBody
    public Page<ClientDTO> findAll(@RequestParam(defaultValue = "0", name = "p") int pageIndex) {
        return clientsService.findAll(pageIndex, 10).map(ClientDTO::new);
    }

    /**
     * Возврат данных о клиенте в виде JSON
     *
     * @return JSON с данными о клиенте.
     */
    @GetMapping("/data/{id}")
    @ResponseBody
    public ClientDTO findById(@PathVariable("id") Long id) {
        return new ClientDTO(clientsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found by id = " + id)));
    }

    /**
     * Сохраняем нового клиента.
     */
    @PostMapping
    public ClientDTO save(@RequestBody @Validated ClientDTO clientDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResourceNotFoundException("Validation exception: " + bindingResult.getAllErrors());
        }
        Client client = new Client(clientDTO.getName());
        clientsService.save(client);
        return new ClientDTO(clientsService.findByName(clientDTO.getName()).get());
    }

    /**
     * Модификация данных клиента:
     * смена имени клиента.
     */
    @PutMapping("/update")
    @ResponseBody
    public ClientDTO updateName(@RequestBody ClientDTO clientDTO) {
        Client client = clientsService.findById(clientDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Client not found by id = " + clientDTO.getId()));
        client.setName(clientDTO.getName());
        clientsService.save(client);
        return new ClientDTO(client);
    }

    /**
     * Удаление клиента
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Client client) {
        clientsService.deleteById(client.getId());
    }
}
