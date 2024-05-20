package com.example.sp2java.repository;

import com.example.sp2java.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, String> {
}
