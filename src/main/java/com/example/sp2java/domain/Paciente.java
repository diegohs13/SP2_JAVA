package com.example.sp2java.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_PACIENTE")
@Entity(name = "TB_PACIENTE")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    private String cpf;

    private String nome_completo;

    private String data_nasc;

    private String end_paciente;

    private String tel_paciente;

    private String email_paciente;

    private String senha;
}
