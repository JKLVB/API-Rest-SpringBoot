package com.cadastro.apirest.model;

import java.io.Serializable;
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

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sq_perfil", sequenceName = "sq_perfil", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_perfil")
	private Integer id;
	private String nome;
	
	@ManyToMany
	@JoinTable(
			name = "usuario_perfil",
			uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "perfil_id"}),
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "perfil_id")
			)
	private List<Usuario> usuario = new ArrayList<>();
	
	public Perfil() {}

	public Perfil(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
}
