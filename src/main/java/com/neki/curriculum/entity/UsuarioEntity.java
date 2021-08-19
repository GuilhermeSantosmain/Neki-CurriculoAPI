package com.neki.curriculum.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@Column(length = 80)
	private String nome;
	@NotNull
	@NotBlank
	@Column(unique = true, length = 64)
	private String email;
	@NotNull
	@NotBlank
	@Column(length = 255)
	@Size(min = 8, max = 255)
	private String senha;	
	@OneToMany(cascade = CascadeType.ALL)
	private List<HabilidadeUsuarioEntity> habilidades;
	
	
	public List<HabilidadeUsuarioEntity> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<HabilidadeUsuarioEntity> habilidades) {
		this.habilidades = habilidades;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
