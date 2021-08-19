package com.neki.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.curriculum.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByEmail(String email);


}
