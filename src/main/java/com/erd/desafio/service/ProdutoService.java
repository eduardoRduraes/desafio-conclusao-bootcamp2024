package com.erd.desafio.service;

import com.erd.desafio.controller.DTOs.ProdutoDTO;
import com.erd.desafio.model.Produto;

public interface ProdutoService {

    Iterable<Produto>listarProdutos();
    Produto buscarPorId(Long id);
    void inserir(ProdutoDTO produtoDTO);
    void atualizar(Long id, Produto produto);
    void deletar(Long id);
}
