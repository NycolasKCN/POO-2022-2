package br.com.nycdev.sistemacomercial;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaComercialMap {
    private Map<String, Client> clientes;
    private Map<String, Product> produtos;

    public SistemaComercialMap() {
        this.clientes = new HashMap<>();
        this.produtos = new HashMap<>();
    }

    public boolean existProduct(Product product) {
        return this.produtos.containsValue(product);
    }

    public Product findProduct(String code) {
        //TODO
        return null;
    }

    public boolean registerProduct(Product product) {
        //TODO
        return false;
    }

    public boolean registerOrder(Pedido order) {
        //TODO
        return false;
    }

    public boolean existOrder(Pedido order) {
        //TODO
        return false;
    }

    public boolean registerClient(Client client) {
        //TODO
        return false;
    }

    public boolean existClient(Client client) {
        return this.clientes.containsValue(client);
    }

    public Client findClient(String id) {
        Client c = this.clientes.get(id);
        if (existClient(c)) {
            return c;
        } else {
            return null;
        }
    }

    public Collection<Client> findClientsByNameInitial(String prefix) {
        //TODO
        return null;
    }

    public Collection<Product> findProductsByCategory(CategoriaProduto category) {
        Collection<Product> p = this.produtos.
        return null;
    }
}