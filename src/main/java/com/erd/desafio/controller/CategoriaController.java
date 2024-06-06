package com.erd.desafio.controller;

import com.erd.desafio.controller.DTOs.CategoriaDTO;
import com.erd.desafio.model.Categoria;
import com.erd.desafio.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    public final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody CategoriaDTO categoriaDTO){
        this.categoriaService.inserir(categoriaDTO);
        return ResponseEntity.ok().build();
    }
}
