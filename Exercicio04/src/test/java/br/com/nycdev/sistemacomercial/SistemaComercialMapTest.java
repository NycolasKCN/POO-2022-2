package br.com.nycdev.sistemacomercial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaComercialMapTest {
    SistemaComercialMap sistema;

    @BeforeEach
    void setup() {
        sistema = new SistemaComercialMap();
    }

    @Test
    public void testRegisterProduct() {
        Product p1 = new Product("123", "Produto 1", 10.0, 10, CategoriaProduto.ALIMENTO);
        Product p2 = new Product("034", "Produto 2", 20.0, 20, CategoriaProduto.ROUPA);

        assertTrue(sistema.registerProduct(p1));
        assertTrue(sistema.registerProduct(p2));
        assertFalse(sistema.registerProduct(p1));
        assertFalse(sistema.registerProduct(p2));
    }

    @Test
    public void testFindProduct() {
        Product p1 = new Product("123", "Produto 1", 10.0, 10, CategoriaProduto.ALIMENTO);

        assertTrue(sistema.registerProduct(p1));
        assertTrue(sistema.findProduct("123").equals(p1));
        assertTrue(null == sistema.findProduct("456"));
    }

    @Test
    public void testRegisterClient() {
        Client c1 = new ClientPF("Nycolas", "Rua tal", "nycolas@gmail.com", "13255507448");

        Client c2 = new ClientPJ("jose", "Rua x", "jose@gmailc.com", "321423425");

        assertTrue(sistema.registerClient(c1));
        assertTrue(sistema.registerClient(c2));
        assertFalse(sistema.registerClient(c1));
        assertFalse(sistema.registerClient(c2));
    }
}
