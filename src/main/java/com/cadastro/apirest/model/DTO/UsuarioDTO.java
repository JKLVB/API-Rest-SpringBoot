package com.cadastro.apirest.model.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private Long cpf;
	
	private String email;
	
	private Long telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	
    private List<Integer> perfil = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public List<Integer> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Integer> perfil) {
		this.perfil = perfil;
	}
}
