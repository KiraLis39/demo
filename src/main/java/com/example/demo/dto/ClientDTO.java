package com.example.demo.dto;

import com.example.demo.repositories.entities.Client;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDTO {
    Long id;

    @NotNull(message = "Имя не может быть пустым!")
    @Length(min = 3, max = 255, message = "Длина имени от 3 до 255 символов!")
    String name;
    @NotNull
    LocalDateTime createDate;

    public ClientDTO(@Valid Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.createDate = client.getCreateDate();
    }
}
