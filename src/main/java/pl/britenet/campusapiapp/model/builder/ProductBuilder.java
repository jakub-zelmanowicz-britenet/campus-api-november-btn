package pl.britenet.campusapiapp.model.builder;

import pl.britenet.campusapiapp.model.Category;
import pl.britenet.campusapiapp.model.Product;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder setId(int id) {
        this.product.setId(id);
        return this;
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.product.setPrice(price);
        return this;
    }

    public ProductBuilder setCategoryId(int categoryId) {
        this.product.setCategoryId(categoryId);
        return this;
    }

    public ProductBuilder setCategory(Category category) {
        this.product.setCategory(category);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }

}
