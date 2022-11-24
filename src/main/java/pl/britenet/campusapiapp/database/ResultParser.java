package pl.britenet.campusapiapp.database;

import java.sql.ResultSet;

public interface ResultParser<T> {

    T parse(ResultSet resultSet);

}
