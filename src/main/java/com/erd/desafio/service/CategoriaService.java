package com.erd.desafio.service;

import com.erd.desafio.controller.DTOs.CategoriaDTO;
import com.erd.desafio.model.Categoria;
import com.erd.desafio.model.Produto;

public interface CategoriaService {
    Iterable<Categoria>listarCategoria();
    Categoria buscarPorId(Long id);
    Categoria buscarPorNome(String nome);
    void inserir(CategoriaDTO categoriaDTO);
}
