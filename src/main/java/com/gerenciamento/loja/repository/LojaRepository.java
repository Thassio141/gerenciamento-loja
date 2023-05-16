package com.gerenciamento.loja.repository;

import com.gerenciamento.loja.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<LojaEntity,Integer> {
}
