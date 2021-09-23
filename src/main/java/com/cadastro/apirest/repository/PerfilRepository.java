package com.cadastro.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.apirest.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
