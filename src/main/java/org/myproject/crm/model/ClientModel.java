package org.myproject.crm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column(length = 15)
    private String cpf;

}
