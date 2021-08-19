package com.neki.curriculum.mapper;

import org.springframework.stereotype.Component;

import com.neki.curriculum.dto.habilidade.HabilidadeDTO;
import com.neki.curriculum.entity.HabilidadeEntity;

@Component
public class HabilidadeMapper {
	
	public HabilidadeEntity toEntity(HabilidadeDTO dto) {
		HabilidadeEntity entity = new HabilidadeEntity();
		
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setImagem(dto.getImagem());
		
		return entity;
	}

	public HabilidadeDTO toDto(HabilidadeEntity entity) {
		HabilidadeDTO dto = new HabilidadeDTO();
		
		dto.setNome(entity.getNome());
		dto.setDescricao(entity.getDescricao());
		dto.setImagem(entity.getImagem());
		
		return dto;
	}
}
