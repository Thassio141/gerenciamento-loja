package com.gerenciamento.loja.dto.produto;

import com.gerenciamento.loja.entity.Categoria;
import lombok.Data;

@Data
public class ProdutoCreateDTO {

    private String nomeProduto;

    private String descricaoProduto;

    private Double preco;

    private Integer quantidade;

    private String codigoBarras;

    private Categoria categoria;

    private String urlImagem;
}
