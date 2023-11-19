package com.br.sbm.fornecedores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "TB_FORNECEDOR")
public class FornecedorModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private String contato;
    private String loja;
    private String cnpj;
    private String situacao;
    private String endereco;
    private String estado;

}
