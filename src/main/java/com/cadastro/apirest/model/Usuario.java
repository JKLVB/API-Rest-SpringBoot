package com.cadastro.apirest.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sq_usuario", sequenceName = "sq_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	private Integer id;
	private String nome;
	private Long cpf;
	private String email;
	private Long telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	
	@ManyToMany
	@JoinTable(
			name = "usuario_perfil",
			uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "perfil_id"}),
			joinColumns = @JoinColumn(name = "perfil_id"),
			inverseJoinColumns = @JoinColumn(name = "usuario_id")
			)
	private List<Perfil> perfil = new ArrayList<>();
	
	public Usuario() {};
	
	public Usuario(Integer id, String nome, Long cpf, String email, Long telefone, LocalDate nascimento,
			List<Perfil> perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}
}
