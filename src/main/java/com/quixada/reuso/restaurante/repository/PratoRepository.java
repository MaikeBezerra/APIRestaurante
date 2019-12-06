package com.quixada.reuso.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quixada.reuso.restaurante.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer>{

}
