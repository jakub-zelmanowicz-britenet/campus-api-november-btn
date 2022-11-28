package pl.britenet.campusapiapp.database;

import com.zaxxer.hikari.HikariConfig;

public class HikariConfigFactory {

    public static HikariConfig createStandardConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/campus-november");
        config.setUsername("root");
        config.setPassword("");
        return config;
    }

}
