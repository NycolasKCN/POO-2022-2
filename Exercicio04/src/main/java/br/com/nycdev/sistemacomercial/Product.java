package br.com.nycdev.sistemacomercial;

public class Product {
    private String code;
    private String description;
    private double productPrice;
    private int quantityInStock;
    private CategoriaProduto category;

    public Product(String code, String description, double productPrice, int quantityInStock, CategoriaProduto category) {
        this.code = code;
        this.description = description;
        this.productPrice = productPrice;
        this.quantityInStock = quantityInStock;
        this.category = category;
    }

    public Product() {
        this(null, null, 0, 0,null);
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", productPrice=" + productPrice +
                ", quantityInStock=" + quantityInStock +
                ", category=" + category +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public CategoriaProduto getCategory() {
        return category;
    }

    public void setCategory(CategoriaProduto category) {
        this.category = category;
    }
}
