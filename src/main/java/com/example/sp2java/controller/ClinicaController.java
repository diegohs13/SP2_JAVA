package com.example.sp2java.controller;

import com.example.sp2java.domain.Clinica;
import com.example.sp2java.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {
    @Autowired
    private ClinicaRepository clinicaRepository;

    //Retorna todas as clinicas
    @GetMapping
    public ResponseEntity getAllClinicas(){
        var todasClinicas = clinicaRepository.findAll();
        return ResponseEntity.ok(todasClinicas);
    }

    //Retorna uma clinica pelo cnpj
    @GetMapping("/{cnpj}")
    public ResponseEntity getClinicaById(@PathVariable String cnpj) {
        Optional<Clinica> clinicaEncontrada = clinicaRepository.findById(cnpj);

        if (clinicaEncontrada.isPresent()) {
            Clinica clinica = clinicaEncontrada.get();
            return ResponseEntity.ok(clinica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra uma nova clinica no banco de dados
    @PostMapping("/cadastrarClinica")
    public Clinica createClinica(@RequestBody Clinica dadosClinica){
        return clinicaRepository.save(dadosClinica);
    }

    //Atualiza o telefone da clinica no banco de dados
    @PutMapping("/{cnpj}/atualizarTelefone")
    public ResponseEntity atualizarTelefone(@PathVariable String cnpj, @RequestBody Clinica dadosClinica){
        Optional<Clinica> clinicaEncontrada = clinicaRepository.findById(cnpj);

        if (clinicaEncontrada.isPresent()) {
            Clinica clinica = clinicaEncontrada.get();
            clinica.setTel_clinica(dadosClinica.getTel_clinica());
            clinicaRepository.save(clinica);
            return ResponseEntity.ok(clinica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta uma clinica do banco de dados
    @DeleteMapping("/{cnpj}/deletarClinica")
    public ResponseEntity deletarClinica(@PathVariable String cnpj){
        Optional<Clinica> clinicaEncontrada = clinicaRepository.findById(cnpj);

        if (clinicaEncontrada.isPresent()) {
            clinicaRepository.delete(clinicaEncontrada.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
