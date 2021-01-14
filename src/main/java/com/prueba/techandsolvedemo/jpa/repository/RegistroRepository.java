/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.techandsolvedemo.jpa.repository;

import com.prueba.techandsolvedemo.jpa.entity.RegistroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface RegistroRepository extends CrudRepository<RegistroEntity, Long>{
    
}
