package com.erd.desafio.service.impl;

import com.erd.desafio.controller.DTOs.ProdutoDTO;
import com.erd.desafio.model.CategoriaRepository;
import com.erd.desafio.model.Produto;
import com.erd.desafio.model.ProdutoRepository;
import com.erd.desafio.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository,CategoriaRepository categoriaRepository){
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Iterable<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(ProdutoDTO produtoDTO) {
        var response = this.categoriaRepository.findByNome(produtoDTO.getCategoria().getNome());

        if(response.isPresent()){
            var data = new Produto();
            BeanUtils.copyProperties(produtoDTO, data);
            this.produtoRepository.save(data);
        }
    }

    @Override
    public void atualizar(Long id, Produto produto) {
        this.produtoRepository.findById(id).ifPresent(p-> this.produtoRepository.save(produto));
    }

    @Override
    public void deletar(Long id) {
        this.produtoRepository.findById(id).ifPresent(this.produtoRepository::delete);
    }
}
