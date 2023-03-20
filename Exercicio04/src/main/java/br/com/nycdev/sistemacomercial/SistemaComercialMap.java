package br.com.nycdev.sistemacomercial;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
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
        Product p = this.produtos.get(code);
        if (!(p == null)) {
            return p;
        }
        return null;
    }

    public boolean registerProduct(Product product) {
        if (!existProduct(product)) {
            this.produtos.put(product.getCode(), product);
            return true;
        }
        return false;
    }

    public boolean registerOrder(Pedido order) {
        // TODO
        return false;
    }

    public boolean existOrder(Pedido order) {
        // TODO
        return false;
    }

    public boolean registerClient(Client client) {
        if (!existClient(client)) {
            this.clientes.put(client.getId(), client);
            return true;
        }
        return false;
    }

    public boolean existClient(Client client) {
        return this.clientes.containsValue(client);
    }

    public Client findClient(String id) {
        Client c = this.clientes.get(id);
        if (!(c == null)) {
            return c;
        }
        return null;
    }

    public Collection<Client> findClientsByNameStartsWith(String prefix) {
        Collection<Client> c = new LinkedList<>();
        this.clientes.forEach(
                (key, value) -> {
                    if (value.getName().startsWith(prefix)) {
                        c.add(value);
                    }
                });
        return null;
    }

    public Collection<Product> findProductsByCategory(CategoriaProduto category) {
        Collection<Product> p = new LinkedList<>();

        this.produtos.forEach(
                (key, value) -> {
                    if (matchCategory(category, value.getCategory())) {
                        p.add(value);
                    }
                });

        return p;
    }

    private boolean matchCategory(CategoriaProduto category, CategoriaProduto other) {
        return category == other;
    }
}