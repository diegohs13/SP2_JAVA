package com.example.sp2java.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "TB_CLINICA")
@Table(name = "TB_CLINICA")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinica {
    @Id
    private String cnpj;

    private String nome_clinica;

    private String tel_clinica;

    private char conveniada;
}
