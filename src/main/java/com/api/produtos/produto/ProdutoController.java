package com.api.produtos.produto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public Set<Produto> getAll(){
        return produtoService.getAll();
    }

    @PutMapping
    public Produto update(@RequestBody @Valid Produto produto){
        return produtoService.update(produto);
    }

    @PostMapping()
    public Produto create(@RequestBody @Valid Produto produto){
        return produtoService.create(produto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        produtoService.delete(id);
    }
}
