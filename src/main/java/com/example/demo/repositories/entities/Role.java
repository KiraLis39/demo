package com.example.demo.repositories.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @org.hibernate.validator.constraints.Length(min = 3, max = 255)
    private String name;
}
