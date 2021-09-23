package com.cadastro.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.apirest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNomeContaining(String nome);
	Usuario findByCpf(Long cpf);
	
}