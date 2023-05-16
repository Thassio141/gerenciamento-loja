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
public class LojaEntity {
    @Id
    private Long idLoja;

    private String nome;

    private String endereco;

    private String telefone;

    //TODO relacionamento com funcionario gerente // one To one
    //TODO relaciomento com funcionarios // one to many
    //TODO relacionamento com vendas // many to many
}
