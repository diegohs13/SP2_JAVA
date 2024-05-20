package com.example.sp2java.controller;

import com.example.sp2java.domain.Unidade;
import com.example.sp2java.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
    @Autowired
    private UnidadeRepository unidadeRepository;

    //Retorna todas as unidades
    @GetMapping
    public ResponseEntity getAllUnidades(){
        var todasUnidades = unidadeRepository.findAll();
        return ResponseEntity.ok(todasUnidades);
    }

    //Retorna uma unidade pelo id
    @GetMapping("/{id_unidade}")
    public ResponseEntity getUnidadeById(@PathVariable String id_unidade) {
        Optional<Unidade> unidadeEncontrada = unidadeRepository.findById(id_unidade);

        if (unidadeEncontrada.isPresent()) {
            Unidade unidade = unidadeEncontrada.get();
            return ResponseEntity.ok(unidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Cadastra uma nova unidade no banco de dados
    @PostMapping("/cadastrarUnidade")
    public Unidade createUnidade(@RequestBody Unidade dadosUnidade){
        return unidadeRepository.save(dadosUnidade);
    }

    //Atualiza o tipo de exame que a unidade atende no banco de dados
    @PutMapping("/{id_unidade}/atualizarTipoExame")
    public ResponseEntity atualizarTipoExame(@PathVariable String id_unidade, @RequestBody Unidade dadosUnidade){
        Optional<Unidade> unidadeEncontrada = unidadeRepository.findById(id_unidade);

        if (unidadeEncontrada.isPresent()) {
            Unidade unidade = unidadeEncontrada.get();
            unidade.setTipo_exame(dadosUnidade.getTipo_exame());
            unidadeRepository.save(unidade);
            return ResponseEntity.ok(unidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta uma unidade do banco de dados
    @DeleteMapping("/{id_unidade}/deletarUnidade")
    public ResponseEntity deletarUnidade(@PathVariable String id_unidade){
        Optional<Unidade> unidadeEncontrada = unidadeRepository.findById(id_unidade);

        if (unidadeEncontrada.isPresent()) {
            unidadeRepository.delete(unidadeEncontrada.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
