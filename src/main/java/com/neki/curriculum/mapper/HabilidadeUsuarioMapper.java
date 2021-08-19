package com.neki.curriculum.mapper;

import org.springframework.stereotype.Component;

import com.neki.curriculum.dto.habilidade.HabilidadeUsuarioDTO;
import com.neki.curriculum.entity.HabilidadeEntity;
import com.neki.curriculum.entity.HabilidadeUsuarioEntity;

@Component
public class HabilidadeUsuarioMapper {
	public HabilidadeUsuarioEntity toEntity(HabilidadeEntity habilidadeEntity, Integer nivel) {
		HabilidadeUsuarioEntity entity = new HabilidadeUsuarioEntity();
		
		entity.setHabilidade(habilidadeEntity);
		entity.setNivel(1);
		
		return entity;
	}

	public HabilidadeUsuarioDTO toDto(HabilidadeUsuarioEntity entity) {
		HabilidadeUsuarioDTO dto = new HabilidadeUsuarioDTO();
		
		dto.setHabilidade(entity.getHabilidade());
		dto.setNivel(entity.getNivel());
		
		return dto;
	}
}
