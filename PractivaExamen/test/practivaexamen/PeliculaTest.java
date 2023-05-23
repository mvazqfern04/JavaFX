/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practivaexamen;

import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class PeliculaTest {
    
    public PeliculaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testToCSV(){
        Pelicula pel = new Pelicula("Aa", LocalDate.now(),"Yo", 10.0);
        String espero = "Aa;2023-05-23;Yo;10.0";
        assertEquals(espero, pel.toCSVFormat());
    }
    
}
