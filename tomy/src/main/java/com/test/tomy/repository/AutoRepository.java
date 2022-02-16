package com.test.tomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.tomy.model.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

}
