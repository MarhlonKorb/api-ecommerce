package com.api.produtos.produto;

import com.api.produtos.abstractentities.IPersistence;
import java.util.Set;

public interface ProdutoService extends IPersistence<Produto> {

    Set<Produto> getAll();
}
