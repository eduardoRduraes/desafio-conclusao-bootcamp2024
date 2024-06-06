package com.erd.desafio.service.impl;

import com.erd.desafio.controller.DTOs.CategoriaDTO;
import com.erd.desafio.model.Categoria;
import com.erd.desafio.model.CategoriaRepository;
import com.erd.desafio.model.Produto;
import com.erd.desafio.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    public final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Iterable<Categoria> listarCategoria() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return this.categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria buscarPorNome(String nome) {
        return this.categoriaRepository.findByNome(nome).orElse(null);
    }

    @Override
    public void inserir(CategoriaDTO categoriaDTO) {
        var data = new Categoria();
        BeanUtils.copyProperties(categoriaDTO,data);
        this.categoriaRepository.save(data);
    }
}
