package com.example.sp2java.controller;

import com.example.sp2java.domain.Agendamento;
import com.example.sp2java.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    //Retorna todos os agendamentos
    @GetMapping
    public ResponseEntity getAllAgendamentos(){
        var todosAgendamentos = agendamentoRepository.findAll();
        return ResponseEntity.ok(todosAgendamentos);
    }

    //Retorna um agendamento pelo n_protocolo
    @GetMapping("/{n_protocolo}")
    public ResponseEntity getAgendamentoByNProtocolo(@PathVariable String n_protocolo) {
        Optional<Agendamento> agendamentoEncontrado = agendamentoRepository.findById(n_protocolo);

        if (agendamentoEncontrado.isPresent()) {
            Agendamento agendamento = agendamentoEncontrado.get();
            return ResponseEntity.ok(agendamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra um novo agendamento no banco de dados
    @PostMapping("/cadastrarAgendamento")
    public Agendamento createAgendamento(@RequestBody Agendamento dadosAgendamento){
        return agendamentoRepository.save(dadosAgendamento);
    }

    //Atualiza a data e hora do agendamento no banco de dados
    @PutMapping("/{n_protocolo}/atualizarDataHora")
    public ResponseEntity atualizarDataHora(@PathVariable String n_protocolo, @RequestBody Agendamento dadosAgendamento){
        Optional<Agendamento> agendamentoEncontrado = agendamentoRepository.findById(n_protocolo);

        if (agendamentoEncontrado.isPresent()) {
            Agendamento agendamento = agendamentoEncontrado.get();
            agendamento.setData_hora_agendamento(dadosAgendamento.getData_hora_agendamento());
            agendamentoRepository.save(agendamento);
            return ResponseEntity.ok(agendamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta um agendamento do banco de dados
    @DeleteMapping("/{n_protocolo}/deletarAgendamento")
    public ResponseEntity deletarAgendamento(@PathVariable String n_protocolo){
        Optional<Agendamento> agendamentoEncontrado = agendamentoRepository.findById(n_protocolo);

        if (agendamentoEncontrado.isPresent()) {
            agendamentoRepository.deleteById(n_protocolo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
