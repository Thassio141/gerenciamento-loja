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
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    //TODO fazer relação com fornecedores / manytomany
    //TODO fazer relação com loja / manytomany
    //TODO fazer relação com estoque / manytomany
}
