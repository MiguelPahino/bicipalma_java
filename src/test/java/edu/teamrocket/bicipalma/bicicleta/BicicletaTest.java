package edu.teamrocket.bicipalma.bicicleta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BicicletaTest {

    private static Bicicleta bici = null;

    @BeforeAll
    public void setup_bicicleta() {
        // ARRANGE
        bici = new Bicicleta(101);
    }
    
    @Test
    public void test_constructor_bicicleta() {
        // ARRANGE
        int idExpected = 101;
        // ACT
        int id = bici.getId();
        // ASSERT
        assertEquals(idExpected, id);
    }

    @Test
    public void test_toString_bicicleta() {
        // ARRANGE
        String id = "101";
        // ACT
        String representacionIdBici = bici.toString();
        // ASSERT
        assertEquals(id, representacionIdBici);
    }
}