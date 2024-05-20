package com.example.sp2java.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_CONSULTAS")
@Entity(name = "TB_CONSULTAS")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    private String id_unidade;

    private String data_hora_consultas;

    private String agendamento_n_protocolo;
}
