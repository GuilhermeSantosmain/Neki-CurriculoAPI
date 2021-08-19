package com.neki.curriculum.mapper;

import org.springframework.stereotype.Component;

import com.neki.curriculum.dto.usuario.UsuarioDTO;
import com.neki.curriculum.entity.UsuarioEntity;

@Component
public class UsuarioMapper {

	public UsuarioEntity toEntity(UsuarioDTO dto) {
		UsuarioEntity entity = new UsuarioEntity();
		
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		entity.setHabilidades(dto.getHabilidades());
		
		return entity;
	}

	public UsuarioDTO toDto(UsuarioEntity entity) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setHabilidades(entity.getHabilidades());
		dto.setSenha(entity.getSenha());
		
		return dto;
	}
	
}
