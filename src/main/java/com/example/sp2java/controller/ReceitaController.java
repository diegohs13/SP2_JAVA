package com.example.sp2java.controller;

import com.example.sp2java.domain.Receita;
import com.example.sp2java.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaRepository receitaRepository;

    //Retorna todas as receitas
    @GetMapping
    public ResponseEntity getAllReceitas(){
        var todasReceitas = receitaRepository.findAll();
        return ResponseEntity.ok(todasReceitas);
    }

    // Retorna uma receita pelo id
    @GetMapping("/{id_receita}")
    public ResponseEntity getReceitaById(@PathVariable String id_receita) {
        Optional<Receita> receitaEncontrada = receitaRepository.findById(id_receita);

        if (receitaEncontrada.isPresent()) {
            Receita receita = receitaEncontrada.get();
            return ResponseEntity.ok(receita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra uma nova receita no banco de dados
    @PostMapping("/cadastrarReceita")
    public Receita createReceita(@RequestBody Receita dadosReceita){
        return receitaRepository.save(dadosReceita);
    }

    //Atualiza o encaminhamento da receita no banco de dados
    @PutMapping("/{id_receita}/atualizarEncaminhamento")
    public ResponseEntity atualizarEncaminhamento(@PathVariable String id_receita, @RequestBody Receita dadosReceita){
        Optional<Receita> receitaEncontrada = receitaRepository.findById(id_receita);

        if (receitaEncontrada.isPresent()) {
            Receita receita = receitaEncontrada.get();
            receita.setEncaminhamento(dadosReceita.getEncaminhamento());
            receitaRepository.save(receita);
            return ResponseEntity.ok(receita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta uma receita do banco de dados
    @DeleteMapping("/{id_receita}/deletarReceita")
    public ResponseEntity deletarReceita(@PathVariable String id_receita){
        receitaRepository.deleteById(id_receita);
        return ResponseEntity.ok().build();
    }
}
