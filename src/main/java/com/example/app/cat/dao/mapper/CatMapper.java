package com.example.app.cat.dao.mapper;

import com.example.app.cat.model.Cat;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author Aliaksandr Miron
 */
@Component
public class CatMapper implements RowMapper<Cat> {

    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String DATE_OF_BIRTH_COLUMN_NAME = "date_of_birth";

    @Override
    public Cat mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Cat cat = new Cat();
        cat.setId(rs.getLong(ID_COLUMN_NAME));
        cat.setName(rs.getString(NAME_COLUMN_NAME));
        cat.setDateOfBirth(rs.getDate(DATE_OF_BIRTH_COLUMN_NAME).toLocalDate());
        return cat;
    }
}
