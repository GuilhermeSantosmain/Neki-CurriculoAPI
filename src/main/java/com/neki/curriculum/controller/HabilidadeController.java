package com.neki.curriculum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.curriculum.dto.habilidade.HabilidadeDTO;
import com.neki.curriculum.dto.usuario.UsuarioDTO;
import com.neki.curriculum.entity.HabilidadeEntity;
import com.neki.curriculum.exception.HabilidadeException;
import com.neki.curriculum.service.HabilidadeService;
import com.neki.curriculum.service.UsuarioService;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	HabilidadeService habilidadeService;
	@PostMapping
	public ResponseEntity<?> postHabilidade(@RequestBody HabilidadeDTO dto) {
		try {
			return new ResponseEntity<>(habilidadeService.postHabilidade(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/usuario")
	public ResponseEntity<?> findAllHabilidadesByUsuario(@RequestBody UsuarioDTO dto) {
		try {
			return new ResponseEntity<>(habilidadeService.findAllHabilidadesByUsuario(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/unused")
	public ResponseEntity<?> findAllHabilidadesUnusedByUsuario(@RequestBody UsuarioDTO dto) {
		try {
			return new ResponseEntity<>(habilidadeService.findAllHabilidadesUnusedByUsuario(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
			throws HabilidadeException {
		try {			
			return new ResponseEntity<HabilidadeEntity>(habilidadeService.findById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
