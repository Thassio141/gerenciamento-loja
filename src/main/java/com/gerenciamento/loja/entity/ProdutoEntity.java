package com.gerenciamento.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoEntity {
    @Id
    private Long idProduto;

    private String nomeProduto;

    private String descricaoProduto;

    private Double preco;

    private Integer quantidade;

    private Boolean disponibilidade;

    private String codigoBarras;

    private Categoria categoria;

//    private guardar imagem do produto
//    private Fornecedor fornecedor; manytomany
}
