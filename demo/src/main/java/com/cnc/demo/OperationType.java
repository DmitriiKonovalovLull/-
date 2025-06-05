package com.cnc.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operation_types")
public class OperationType {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
}

