package com.tcc.felippe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.felippe.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
