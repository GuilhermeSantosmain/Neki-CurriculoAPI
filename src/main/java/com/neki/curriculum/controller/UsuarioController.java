package com.neki.curriculum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.curriculum.dto.habilidade.HabilidadeUsuarioDTO;
import com.neki.curriculum.dto.usuario.UsuarioDTO;
import com.neki.curriculum.entity.UsuarioEntity;
import com.neki.curriculum.exception.UsuarioException;
import com.neki.curriculum.service.HabilidadeService;
import com.neki.curriculum.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	HabilidadeService habilidadeService;
	@PostMapping
	public ResponseEntity<?> postUsuario(@RequestBody UsuarioDTO dto) {
		try {
			return new ResponseEntity<>(usuarioService.postUsuario(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}@PostMapping("/login")
	public ResponseEntity<?> loginUsuario(@RequestBody UsuarioDTO dto) {
		try {
			return new ResponseEntity<>(usuarioService.loginUsuario(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/adiciona/{idUsuario}")
	public ResponseEntity<?> adicionaHabilidade(@PathVariable Long idUsuario,@RequestBody HabilidadeUsuarioDTO HUDTO) {
		try {
			return new ResponseEntity<>(usuarioService.adicionaHabilidade(idUsuario, HUDTO.getHabilidade().getId(), HUDTO.getNivel()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/remove/{idHabilidade}")
	public ResponseEntity<?> removeHabilidade(@RequestBody UsuarioDTO dto,@PathVariable Long idHabilidade) {
		try {
			return new ResponseEntity<>(usuarioService.removeHabilidade(dto, idHabilidade), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@PutMapping("/editar/habilidade")
	public ResponseEntity<?> editarHabilidade(@RequestBody HabilidadeUsuarioDTO dto) {
		try {
			return new ResponseEntity<>(usuarioService.editarHabilidade(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
			throws UsuarioException {
		try {			
			return new ResponseEntity<UsuarioEntity>(usuarioService.findById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
