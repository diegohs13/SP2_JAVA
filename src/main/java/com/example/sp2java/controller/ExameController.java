package com.example.sp2java.controller;

import com.example.sp2java.domain.Exame;
import com.example.sp2java.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExameController {
    @Autowired
    private ExameRepository exameRepository;

    //Retorna todos os exames
    @GetMapping
    public ResponseEntity getAllExames(){
        var todosExames = exameRepository.findAll();
        return ResponseEntity.ok(todosExames);
    }

    //Retorna um exame pelo id
    @GetMapping("/{id_exame}")
    public ResponseEntity getExameById(@PathVariable String id_exame) {
        Optional<Exame> exameEncontrado = exameRepository.findById(id_exame);

        if (exameEncontrado.isPresent()) {
            Exame exame = exameEncontrado.get();
            return ResponseEntity.ok(exame);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra um novo exame no banco de dados
    @PostMapping("/cadastrarExame")
    public Exame createExame(@RequestBody Exame dadosExame){
        return exameRepository.save(dadosExame);
    }

    //Atualiza o resultado do exame no banco de dados
    @PutMapping("/{id_exame}/atualizarResultado")
    public ResponseEntity atualizarResultado(@PathVariable String id_exame, @RequestBody Exame dadosExame){
        Optional<Exame> exameEncontrado = exameRepository.findById(id_exame);

        if (exameEncontrado.isPresent()) {
            Exame exame = exameEncontrado.get();
            exame.setResultado(dadosExame.getResultado());
            exameRepository.save(exame);
            return ResponseEntity.ok(exame);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta um exame do banco de dados
    @DeleteMapping("/{id_exame}/deletarExame")
    public ResponseEntity deletarExame(@PathVariable String id_exame){
        exameRepository.deleteById(id_exame);
        return ResponseEntity.ok().build();
    }
}
