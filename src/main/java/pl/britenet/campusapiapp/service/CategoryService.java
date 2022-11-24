package pl.britenet.campusapiapp.service;

import pl.britenet.campusapiapp.database.DatabaseService;
import pl.britenet.campusapiapp.model.Category;
import pl.britenet.campusapiapp.model.builder.CategoryBuilder;

import java.sql.SQLException;

public class CategoryService {

    private final DatabaseService databaseService;

    public CategoryService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void insertCategory(Category category) {
        String dml = String.format("INSERT INTO category (name) VALUES (%s)",
                category.getName());
        this.databaseService.performDML(dml);
    }

    public Category getCategory(int id) {
        String sql = String.format("SELECT * FROM category WHERE id = %d",
                id);

        return this.databaseService.performSQL(sql, resultSet -> {
            try {
                if (resultSet.next()) {
                    return new CategoryBuilder()
                            .setName(resultSet.getString("name"))
                            .getCategory();

                }
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return null;
        });
    }
}
