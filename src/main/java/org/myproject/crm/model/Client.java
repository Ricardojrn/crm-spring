package org.myproject.crm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nome")
    private String name;
    @Column
    private String email;
    @Column(length = 15)
    private String cpf;

}
