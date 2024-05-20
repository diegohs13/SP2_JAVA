package com.example.sp2java.controller;

import com.example.sp2java.domain.Paciente;
import com.example.sp2java.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    //Retorna todos os pacientes
    @GetMapping
    public ResponseEntity getAllPacientes(){
        var todosPacientes = pacienteRepository.findAll();
        return ResponseEntity.ok(todosPacientes);
    }

    //Retorna um paciente pelo cpf
    @GetMapping("/{cpf}")
    public ResponseEntity getPacienteById(@PathVariable String cpf) {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(cpf);

        if (pacienteEncontrado.isPresent()) {
            Paciente paciente = pacienteEncontrado.get();
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra um novo paciente no banco de dados
    @PostMapping("/cadastrarPaciente")
    public Paciente createPaciente(@RequestBody Paciente dadosPaciente){
        return pacienteRepository.save(dadosPaciente);
    }

    //Atualiza a senha do paciente no banco de dados
    @PutMapping("/{cpf}/atualizarSenha")
    public ResponseEntity atualizarSenha(@PathVariable String cpf, @RequestBody Paciente dadosPaciente){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(cpf);

        if (pacienteEncontrado.isPresent()) {
            Paciente paciente = pacienteEncontrado.get();
            paciente.setSenha(dadosPaciente.getSenha());
            pacienteRepository.save(paciente);
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta um paciente do banco de dados
    @DeleteMapping("/{cpf}/deletarPaciente")
    public ResponseEntity deletarPaciente(@PathVariable String cpf){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(cpf);

        if (pacienteEncontrado.isPresent()) {
            pacienteRepository.delete(pacienteEncontrado.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Realiza o login do paciente
    @PostMapping("/{cpf}/login")
    public ResponseEntity login(@PathVariable String cpf, @RequestBody Paciente dadosPaciente){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(cpf);

        if (pacienteEncontrado.isPresent()) {
            Paciente paciente = pacienteEncontrado.get();
            if(paciente.getSenha().equals(dadosPaciente.getSenha())){
                return ResponseEntity.ok(paciente);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
