package com.example.sp2java.controller;

import com.example.sp2java.domain.Consulta;
import com.example.sp2java.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;

    //Retorna todas as consultas
    @GetMapping
    public ResponseEntity getAllConsultas(){
        var todasConsultas = consultaRepository.findAll();
        return ResponseEntity.ok(todasConsultas);
    }

    //Retorna uma consulta pelo id
    @GetMapping("/{id_unidade}")
    public ResponseEntity getConsultaById(@PathVariable String id_unidade) {
        Optional<Consulta> consultaEncontrada = consultaRepository.findById(id_unidade);

        if (consultaEncontrada.isPresent()) {
            Consulta consulta = consultaEncontrada.get();
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastrar uma nova consulta no banco de dados
    @PostMapping("/cadastrarConsulta")
    public Consulta createConsulta(@RequestBody Consulta dadosConsulta){
        return consultaRepository.save(dadosConsulta);
    }

    //Atualiza a data e hora da consulta no banco de dados
    @PutMapping("/{id_unidade}/atualizarDataHora")
    public ResponseEntity atualizarDataHora(@PathVariable String id_unidade, @RequestBody Consulta dadosConsulta){
        Optional<Consulta> consultaEncontrada = consultaRepository.findById(id_unidade);

        if (consultaEncontrada.isPresent()) {
            Consulta consulta = consultaEncontrada.get();
            consulta.setData_hora_consultas(dadosConsulta.getData_hora_consultas());
            consultaRepository.save(consulta);
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta uma consulta do banco de dados
    @DeleteMapping("/{id_unidade}/deletarConsulta")
    public ResponseEntity deletarConsulta(@PathVariable String id_unidade){
        Optional<Consulta> consultaEncontrada = consultaRepository.findById(id_unidade);

        if (consultaEncontrada.isPresent()) {
            consultaRepository.deleteById(id_unidade);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
