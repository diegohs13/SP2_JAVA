package com.example.sp2java.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "TB_EXAME")
@Entity(name = "TB_EXAME")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exame {
    @Id
    private String id_exame;

    private String tipo_exame;

    private String resultado;
}
