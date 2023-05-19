package com.gerenciamento.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorEntity {


    @Id
    private Long idFornecedor;

    private String nomeFornecedor;

    private Endereco enderecoFornecedor;

    private String emailFornecedor;

    private String telefoneFornecedor;

    private Boolean ativo;

    @OneToMany(mappedBy = "fornecedor")
    private List<ProdutoEntity> produtosFornecidos;
}
