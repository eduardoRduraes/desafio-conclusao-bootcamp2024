package com.erd.desafio.controller;

import com.erd.desafio.controller.DTOs.ProdutoDTO;
import com.erd.desafio.model.Produto;
import com.erd.desafio.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Produto>> listar(){
        return ResponseEntity.status(201).body(this.produtoService.listarProdutos());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody ProdutoDTO produtoDTO){
        this.produtoService.inserir(produtoDTO);
        return ResponseEntity.ok(produtoDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto>atualizar(@RequestBody Produto produto, @PathVariable("id")Long id){
        this.produtoService.atualizar(id, produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id")Long id){
        this.produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

