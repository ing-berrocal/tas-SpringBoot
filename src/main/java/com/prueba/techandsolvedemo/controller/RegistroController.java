/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.techandsolvedemo.controller;

import com.prueba.techandsolvedemo.servicio.RegistroServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@CrossOrigin(origins = {"*"})
@RequestMapping(value = "/api/registro")
@RestController
public class RegistroController {
    
    @Autowired
    private RegistroServicio servicio;
    
    @GetMapping
    public ResponseEntity getListado(){                                
        return ResponseEntity.ok(servicio.getLIstatoRegistro())       ;
    }
    
    @PostMapping
    public ResponseEntity postRegistro(@RequestParam String documento, @RequestParam("archivo") MultipartFile file){
        try {
            servicio.registro(documento,file);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
