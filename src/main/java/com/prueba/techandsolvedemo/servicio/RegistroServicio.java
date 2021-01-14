/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.techandsolvedemo.servicio;

import com.prueba.techandsolvedemo.jpa.entity.RegistroEntity;
import com.prueba.techandsolvedemo.jpa.repository.RegistroRepository;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Service
@RequestScope
public class RegistroServicio {

    @Autowired
    private RegistroRepository repositorio;

    public List getLIstatoRegistro() {
        return (List) repositorio.findAll();
    }

    public void registro(String documento, MultipartFile archivoEntrada) throws Exception {

        RegistroEntity registro = new RegistroEntity();
        registro.setDocumento(documento);
        registro.setFecha(Calendar.getInstance().getTime());
        byte[] archivo = archivoEntrada.getBytes();

        registro.setArchivo(archivo);

        String entrada = new String(archivo);

        String[] split = entrada.split("\n");
        int[] toArray = Stream.of(split).mapToInt(Integer::parseInt).toArray();

        CalculoViajes calculo = CalculoViajes.getInstance(toArray);
        Integer[] resultadoViaje = calculo.procesar();
        registro.setResultado(getResultado(resultadoViaje));

        insertarRegistro(registro);
    }

    private void insertarRegistro(RegistroEntity registro) {
        repositorio.save(registro);
    }

    private byte[] getResultado(Integer[] resultado) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter pw = new PrintWriter(out)) {
            int i = 0;
            for (Integer in : resultado) {
                pw.println(String.format("Case #%d: %d", ++i, in));
            }
        }
        return out.toByteArray();
    }
}
