package com.erd.desafio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_produtos")
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    private Categoria categoria;
}
