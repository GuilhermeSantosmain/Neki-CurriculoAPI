package com.neki.curriculum.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.curriculum.dto.habilidade.HabilidadeUsuarioDTO;
import com.neki.curriculum.dto.usuario.UsuarioDTO;
import com.neki.curriculum.entity.HabilidadeEntity;
import com.neki.curriculum.entity.HabilidadeUsuarioEntity;
import com.neki.curriculum.entity.UsuarioEntity;
import com.neki.curriculum.exception.UsuarioException;
import com.neki.curriculum.mapper.HabilidadeUsuarioMapper;
import com.neki.curriculum.mapper.UsuarioMapper;
import com.neki.curriculum.repository.HabilidadeUsuarioRepository;
import com.neki.curriculum.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioMapper usuarioMapper;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	HabilidadeService habilidadeService;
	@Autowired
	HabilidadeUsuarioService habilidadeUsuarioService;
	@Autowired
	HabilidadeUsuarioMapper habilidadeUsuarioMapper;
	@Autowired
	HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	
	
	public UsuarioEntity postUsuario(UsuarioDTO dto) throws UsuarioException {

		if (dto.getNome() == null || dto.getEmail() == null || dto.getSenha() == null) {
			throw new UsuarioException("Para cadastrar usuario é necessário informar todos os campos");
		}

		UsuarioEntity entity = usuarioMapper.toEntity(dto);
		return usuarioRepository.save(entity);

	}
	public UsuarioEntity findById(Long id) throws EntityNotFoundException {

		return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}
	public UsuarioEntity adicionaHabilidade(Long idHabilidade, UsuarioDTO dto) throws UsuarioException {
		if(dto.getId() == null || idHabilidade == null) {
			throw new UsuarioException("id habilidade e/ou id usuario são nulos");
		}
		
		UsuarioEntity usuario = findById(dto.getId());
		HabilidadeEntity habilidade = habilidadeService.findById(idHabilidade);
		
		
		List<HabilidadeUsuarioEntity> habilidades = usuario.getHabilidades();
		
		if(!habilidades.isEmpty()) {
			for(HabilidadeUsuarioEntity HUE : habilidades) {
				if(HUE.getHabilidade() == habilidade)
					throw new UsuarioException("usuario ja contem a habilidade");
			}
		}
		HabilidadeUsuarioEntity habilidadeUsuario = habilidadeUsuarioMapper.toEntity(habilidade);
		habilidadeUsuarioRepository.save(habilidadeUsuario);
		habilidades.add(habilidadeUsuario);
		usuario.setHabilidades(habilidades);
		
		return usuarioRepository.save(usuario);
	}
	public HabilidadeUsuarioEntity editarHabilidade(HabilidadeUsuarioDTO dto, Integer nivel ) throws UsuarioException {
		if(dto.getId() == null || nivel == null) {
			throw new UsuarioException("id habilidade e/ou id usuario são nulos");
		}
		
		HabilidadeUsuarioEntity habilidade = habilidadeUsuarioService.findById(dto.getId());
		
		habilidade.setNivel(nivel);
		
		return habilidadeUsuarioRepository.save(habilidade);
	}
	public UsuarioEntity removeHabilidade(UsuarioDTO dto, Long idHabilidadeUsuario ) throws UsuarioException {
		if(dto.getId() == null || idHabilidadeUsuario == null) {
			throw new UsuarioException("id habilidade e/ou id usuario são nulos");
		}
		
		UsuarioEntity usuario = findById(dto.getId());
		HabilidadeUsuarioEntity habilidade = habilidadeUsuarioService.findById(idHabilidadeUsuario);
		
		List<HabilidadeUsuarioEntity> habilidades = usuario.getHabilidades();
		
		if(!habilidades.contains(habilidade)) {
			throw new UsuarioException("usuario nao contem a habilidade id: " + habilidade.getId());
		}
		habilidades.remove(habilidade);
		usuario.setHabilidades(habilidades);
		
		return usuarioRepository.save(usuario);
	}
	public UsuarioEntity loginUsuario(UsuarioDTO dto) throws UsuarioException {
		if (dto.getEmail() == null || dto.getSenha() == null) {
			throw new UsuarioException("Para logar usuario é necessário informar todos os campos");
		}
		UsuarioEntity usuario = usuarioRepository.findByEmail(dto.getEmail());
		if(usuario.getSenha().equals(dto.getSenha())) {
			return usuario;
		}
		return null;
	}
}
