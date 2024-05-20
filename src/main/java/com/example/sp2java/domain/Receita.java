package com.example.sp2java.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_RECEITA")
@Entity(name = "TB_RECEITA")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
    @Id
    private String id_receita;

    private String encaminhamento;

    private String data_prescricao;

    private String medico_crm;

    private String paciente_cpf;
}
