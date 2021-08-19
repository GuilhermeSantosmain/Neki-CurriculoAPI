package com.neki.curriculum.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.curriculum.dto.habilidade.HabilidadeDTO;
import com.neki.curriculum.dto.usuario.UsuarioDTO;
import com.neki.curriculum.entity.HabilidadeEntity;
import com.neki.curriculum.entity.HabilidadeUsuarioEntity;
import com.neki.curriculum.entity.UsuarioEntity;
import com.neki.curriculum.exception.HabilidadeException;
import com.neki.curriculum.mapper.HabilidadeMapper;
import com.neki.curriculum.repository.HabilidadeRepository;
import com.neki.curriculum.repository.HabilidadeUsuarioRepository;

@Service
public class HabilidadeService {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	HabilidadeRepository habilidadeRepository;
	@Autowired
	HabilidadeMapper habilidadeMapper;
	@Autowired
	HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	
	public HabilidadeEntity postHabilidade(HabilidadeDTO dto) throws HabilidadeException {

		if (dto.getNome() == null || dto.getDescricao() == null || dto.getImagem() == null) {
			throw new HabilidadeException("Para cadastrar habilidade é necessário informar todos os campos");
		}

		HabilidadeEntity entity = habilidadeMapper.toEntity(dto);
		return habilidadeRepository.save(entity);

	}
	
	public HabilidadeEntity findById(Long id) throws EntityNotFoundException {

		return habilidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}

	public List<HabilidadeUsuarioEntity> findAllHabilidadesByUsuario(UsuarioDTO dto) throws HabilidadeException {
		if (dto.getId() == null) {
			throw new HabilidadeException("de usuario nulo");
		}
		UsuarioEntity usuario = usuarioService.findById(dto.getId());
		List<HabilidadeUsuarioEntity> habilidades = (usuario.getHabilidades());
		
		return habilidades;
	}

	public List<HabilidadeEntity> findAllHabilidadesUnusedByUsuario(UsuarioDTO dto) throws HabilidadeException {
		if (dto.getId() == null) {
			throw new HabilidadeException("de usuario nulo");
		}
		List<HabilidadeEntity> listaHabilidades = habilidadeRepository.findAll();
		UsuarioEntity usuario = usuarioService.findById(dto.getId());
		List<HabilidadeUsuarioEntity> habilidadesUsuario = (usuario.getHabilidades());
		
		for(HabilidadeUsuarioEntity skill : habilidadesUsuario) {
			listaHabilidades.remove(skill.getHabilidade());
			
		}
		
		return listaHabilidades;
	}
}
