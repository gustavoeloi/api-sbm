package com.br.sbm.fornecedores.controller;

import com.br.sbm.fornecedores.dto.FornecedorRecordDto;
import com.br.sbm.fornecedores.model.FornecedorModel;
import com.br.sbm.fornecedores.repository.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FornecedorController {

    @Autowired
    FornecedorRepository fornecedorRepository;

//  Listar todos os fornecedores
    @GetMapping("/fornecedores")
    public ResponseEntity<List<FornecedorModel>> getAllFornecedores(){
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.findAll());
    }

    @PostMapping("/fornecedores")
    public ResponseEntity<FornecedorModel> saveProduct(@RequestBody FornecedorRecordDto fornecedorRecordDto){
        var fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorRecordDto, fornecedorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(fornecedorModel));
    }

    @DeleteMapping("/fornecedores/{id}")
    public ResponseEntity<Object> deleteFornecedor(@PathVariable(value = "id") UUID id){
        Optional<FornecedorModel> productO = fornecedorRepository.findById(id);
        if(productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Fornecedor excluido com sucesso!");
        }
    }


}
