package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testeConsulta() {
        Main app = new Main();
        String query = app.consultaInsegura("admin");
        assertTrue(query.contains("SELECT"));
    }
}