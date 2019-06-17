package com.tcc.felippe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tcc.felippe.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
