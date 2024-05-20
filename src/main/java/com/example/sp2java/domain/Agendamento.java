package com.example.sp2java.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_AGENDAMENTO")
@Entity(name = "TB_AGENDAMENTO")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
    @Id
    private String n_protocolo;

    private String data_hora_agendamento;

    private String unidade_id_unidade;

    private String paciente_cpf;
}
