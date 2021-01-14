/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.techandsolvedemo.servicio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class CalculoViajesTest {

    public CalculoViajesTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calcularViaje method, of class CalculoViajes.
     */
    @Test
    public void testCalcularViaje() {
        int[] data = new int[]{1, 3, 20, 20, 20};
        Integer expResult = 1;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajeUnItem() {
        int[] data = new int[]{1, 1, 30};
        Integer expResult = 1;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularUnViajeItemMax50() {
        int[] data = new int[]{1, 1, 51};
        Integer expResult = 1;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularDosViajesItemMin50() {
        int[] data = new int[]{1, 3, 30, 20, 10};
        Integer expResult = 2;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularDosViajesItemMin50ArrayPar() {
        int[] data = new int[]{1, 4, 30, 20, 10, 5};
        Integer expResult = 2;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularDosViajesItemMin50ArrayImpar() {
        int[] data = new int[]{1, 5, 30, 20, 10, 5, 1};
        int inicio = 0;
        int fina = data.length;
        Integer expResult = 2;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularDosViajesItemsMax50() {
        int[] data = new int[]{1, 2, 60, 51};
        Integer expResult = 2;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesItemsMax50Par() {
        int[] data = new int[]{1, 6, 60, 82, 91, 52, 90, 75};
        Integer expResult = 6;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesItemsMax50Impar() {
        int[] data = new int[]{1, 7, 52, 89, 90, 74, 56, 79, 92};
        Integer expResult = 7;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesItemsMixPar() {
        int[] data = new int[]{1, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91};
        Integer expResult = 8;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesItemsMixImpar() {
        int[] data = new int[]{1, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer expResult = 2;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesItemsMixImpara() {
        int[] data = new int[]{1, 7, 2, 3, 4, 5, 6, 7, 8};
        Integer expResult = 1;
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertEquals(expResult, result[0]);
    }

    @Test
    public void testCalcularViajesMultiple() {
        int[] data = new int[]{2, 7, 2, 3, 4, 5, 6, 7, 8, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91};
        Integer result[] = CalculoViajes.getInstance(data).procesar();
        assertAll(
                () -> assertEquals(2, result.length),
                () -> assertEquals(1, result[0]),
                () -> assertEquals(8, result[1])
        );
    }
    
    @Test
    public void testExcepcionDia() {
        RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, () -> {
            int[] data = new int[]{501, 7, };
            CalculoViajes.getInstance(data).procesar();
        });     
        
        assertTrue("Parametro dias excede restricción".equalsIgnoreCase(assertThrows.getMessage()));
    }
    
    @Test
    public void testExcepcionElemento() {
        RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, () -> {
            int[] data = new int[]{500, 101, };
            CalculoViajes.getInstance(data).procesar();
        });     
        
        assertTrue("Parametro numero de elementos excede restricción".equalsIgnoreCase(assertThrows.getMessage()));
    }
    
    @Test
    public void testExcepcionPesoMayor() {
        RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, () -> {
            int[] data = new int[]{1, 1, 101};
            CalculoViajes.getInstance(data).procesar();
        });     
        
        assertTrue("Parametro peso excede restricción".equalsIgnoreCase(assertThrows.getMessage()));
    }
    
    @Test
    public void testExcepcionMenor() {
        RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, () -> {
            int[] data = new int[]{1, 2, 100,0};
            CalculoViajes.getInstance(data).procesar();
        });     
        
        assertTrue("Parametro peso excede restricción".equalsIgnoreCase(assertThrows.getMessage()));
    }

}
