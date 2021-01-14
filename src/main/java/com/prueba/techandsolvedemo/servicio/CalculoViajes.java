/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.techandsolvedemo.servicio;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class CalculoViajes {
    
    private final int[] entrada;

    private CalculoViajes(int[] entrada) {
        this.entrada = entrada;
    }
    
    public Integer[] procesar(){
        
        int dias = entrada[0];
            if(dias < 1 || dias > 500) throw new RuntimeException("Parametro dias excede restricción");
            
        Integer[] resultado = new Integer[dias];
        int j = 0;
        for(int i=1;i<entrada.length;i++){
            int numeroElementos = entrada[i];
            if(numeroElementos < 1 || numeroElementos > 100) throw new RuntimeException("Parametro numero de elementos excede restricción");
            
            Integer calcularViaje = calcularViaje(entrada, i+1, i+numeroElementos);
            resultado[j] = calcularViaje;
            i += numeroElementos;
            j++;
            //System.out.printf("Case #%d: %d \n",++j,calcularViaje);            
        }
        
        return resultado;
    }
    
    
    private Integer calcularViaje(int[] data,int inicio,int fina){
        int[] copyOfRange = Arrays.copyOfRange(data, inicio, fina+1);
        Arrays.sort(copyOfRange);
        int viaje = 0, i = 0;
        if(copyOfRange[i] < 1) throw new RuntimeException("Parametro peso excede restricción");
        int max = copyOfRange.length-1;                
        if(copyOfRange[max] > 100) throw new RuntimeException("Parametro peso excede restricción");
        do{
            int acum = copyOfRange[max];            
            for(;i<max && acum<=50;i++){
                acum += copyOfRange[max];                             
            }            
            viaje++;
            max--;
        }while(i <= max);
        return viaje;
    }
    
    public static CalculoViajes getInstance(int[] entrada){
        return new CalculoViajes(entrada);
    }
}
