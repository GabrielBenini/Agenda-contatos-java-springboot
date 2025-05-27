package com.gabriel.nova_agenda_contatos.repository;

import com.gabriel.nova_agenda_contatos.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {

    boolean existsByEmail(String email);


}
