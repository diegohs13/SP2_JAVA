package com.example.sp2java.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_UNIDADE")
@Entity(name = "TB_UNIDADE")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unidade {
    @Id
    private String id_unidade;

    private String end_unidade;

    private String tipo_exame;

    private char atende;

    private String clinica_cnpj;
}
