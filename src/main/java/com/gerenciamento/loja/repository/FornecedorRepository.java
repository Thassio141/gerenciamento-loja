package com.gerenciamento.loja.repository;

import com.gerenciamento.loja.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity,Long> {
}
