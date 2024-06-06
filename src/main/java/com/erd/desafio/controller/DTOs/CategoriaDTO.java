package com.erd.desafio.controller.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoriaDTO {
    @NotBlank
    private String nome;
}
