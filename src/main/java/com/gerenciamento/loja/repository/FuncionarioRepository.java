package com.gerenciamento.loja.repository;

import com.gerenciamento.loja.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity,Long> {
}
