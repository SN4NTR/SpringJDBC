package com.example.app.cat.dao;

import static com.example.app.cat.dao.mapper.CatMapper.DATE_OF_BIRTH_COLUMN_NAME;
import static com.example.app.cat.dao.mapper.CatMapper.ID_COLUMN_NAME;
import static com.example.app.cat.dao.mapper.CatMapper.NAME_COLUMN_NAME;
import static java.lang.String.format;

import com.example.app.cat.model.Cat;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliaksandr Miron
 */
@AllArgsConstructor
@Repository
@Validated
public class CatDaoImpl implements CatDao {

    private static final String CATS_TABLE_NAME = "cats";
    private static final String SELECT_ALL = format("SELECT * FROM %s", CATS_TABLE_NAME);
    private static final String SELECT_BY_ID = format("SELECT * FROM %s WHERE %s=?", CATS_TABLE_NAME, ID_COLUMN_NAME);
    private static final String INSERT = format("INSERT INTO %s (%s, %s) VALUES (?, ?)", CATS_TABLE_NAME, NAME_COLUMN_NAME, DATE_OF_BIRTH_COLUMN_NAME);
    private static final String UPDATE = format("UPDATE %s SET %s=?, %s=? WHERE %s=?", CATS_TABLE_NAME, NAME_COLUMN_NAME, DATE_OF_BIRTH_COLUMN_NAME, ID_COLUMN_NAME);
    private static final String DELETE = format("DELETE FROM %s WHERE %s=?", CATS_TABLE_NAME, ID_COLUMN_NAME);

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Cat> rowMapper;

    @Override
    public List<Cat> getAll() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    @Override
    public Optional<Cat> getById(@NotNull final Long id) {
        final Object[] args = {id};
        final List<Cat> cats = jdbcTemplate.query(SELECT_BY_ID, args, rowMapper);
        return cats.isEmpty()
                ? Optional.empty()
                : Optional.of(cats.get(0));
    }

    @Override
    public void create(@NotNull final Cat cat) {
        final Object[] args = {cat.getName(), cat.getDateOfBirth()};
        jdbcTemplate.update(INSERT, args);
    }

    @Override
    public void update(@NotNull final Long id, @NotNull final Cat cat) {
        final Object[] args = {cat.getName(), cat.getDateOfBirth(), id};
        jdbcTemplate.update(UPDATE, args);
    }

    @Override
    public void delete(@NotNull final Long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
