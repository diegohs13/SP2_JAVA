package com.example.sp2java.repository;

import com.example.sp2java.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
}
