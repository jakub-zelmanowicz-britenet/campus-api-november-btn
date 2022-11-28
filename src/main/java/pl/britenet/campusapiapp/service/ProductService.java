package pl.britenet.campusapiapp.service;

import pl.britenet.campusapiapp.database.DatabaseService;
import pl.britenet.campusapiapp.model.Category;
import pl.britenet.campusapiapp.model.Product;
import pl.britenet.campusapiapp.model.builder.CategoryBuilder;
import pl.britenet.campusapiapp.model.builder.ProductBuilder;

import java.sql.SQLException;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Product getProduct(int id) {
        String sql = String.format("SELECT p.name AS product_name, p.price AS product_price, c.id AS category_id, c.name AS category_name FROM product p INNER JOIN category c ON p.category_id = c.id WHERE p.id = %d",
                id);

        return this.databaseService.performSQL(sql, resultSet -> {
            try {
                if (resultSet.next()) {

                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("category_id"))
                            .setName(resultSet.getString("category_name"))
                            .getCategory();

                    return new ProductBuilder()
                            .setId(id)
                            .setName(resultSet.getString("product_name"))
                            .setPrice(resultSet.getDouble("product_price"))
                            .setCategoryId(category.getId())
                            .setCategory(category)
                            .getProduct();

                }
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return null;
        });
    }

}
