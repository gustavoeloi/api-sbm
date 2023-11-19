package com.br.sbm.fornecedores.repository;

import com.br.sbm.fornecedores.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, UUID> {
}
