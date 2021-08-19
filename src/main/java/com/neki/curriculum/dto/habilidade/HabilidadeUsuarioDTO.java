package com.neki.curriculum.dto.habilidade;

import com.neki.curriculum.entity.HabilidadeEntity;

public class HabilidadeUsuarioDTO {
	
	private Long id;
	private HabilidadeEntity habilidade;
	private Integer nivel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public HabilidadeEntity getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(HabilidadeEntity habilidade) {
		this.habilidade = habilidade;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
}
