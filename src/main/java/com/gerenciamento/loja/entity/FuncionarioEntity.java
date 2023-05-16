package com.gerenciamento.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FuncionarioEntity {
    @Id
    private Long idFuncionario;

    private String nomeFuncionario;

    private String endereco;

    private String telefone;

    private TipoFuncionario tipoFuncionario;

    //TODO relacionamento com uma loja // many to one
}
