package com.neki.curriculum.dto.usuario;

import java.util.List;

import com.neki.curriculum.entity.HabilidadeEntity;
import com.neki.curriculum.entity.HabilidadeUsuarioEntity;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String senha;	
	private List<HabilidadeUsuarioEntity> habilidades;
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
	public List<HabilidadeUsuarioEntity> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<HabilidadeUsuarioEntity> habilidades) {
		this.habilidades = habilidades;
	}
	
	
}
