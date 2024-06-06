package com.erd.desafio.controller.DTOs;

import com.erd.desafio.model.Categoria;
import com.erd.desafio.model.UnidadeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
public class ProdutoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    @Size(max=2)
    private UnidadeMedida unidadeMedida;
    @NotBlank
    private Categoria categoria;

    public ProdutoDTO(String nome, UnidadeMedida unidadeMedida, Categoria categoria){
        BeanUtils.copyProperties(this.categoria, categoria);
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
    }
}
