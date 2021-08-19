package com.neki.curriculum.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.curriculum.entity.HabilidadeUsuarioEntity;
import com.neki.curriculum.repository.HabilidadeUsuarioRepository;

@Service
public class HabilidadeUsuarioService {

	@Autowired
	HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	public HabilidadeUsuarioEntity findById(Long id) throws EntityNotFoundException {

		return habilidadeUsuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}
}
