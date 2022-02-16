package com.test.tomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.tomy.model.Inspeccion;

@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Long>{

}
