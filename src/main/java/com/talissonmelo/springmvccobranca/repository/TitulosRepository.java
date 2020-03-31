package com.talissonmelo.springmvccobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.springmvccobranca.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo, Long> {

}
