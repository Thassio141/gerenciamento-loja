package com.gerenciamento.loja.dto.fornecedor;

import com.gerenciamento.loja.entity.ProdutoEntity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class FornecedorCreateDTO {

    private String nomeFornecedor;

    private String emailFornecedor;

    private String telefoneFornecedor;
}
