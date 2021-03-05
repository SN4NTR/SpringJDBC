package com.example.app.cat.dao;

import com.example.app.cat.model.Cat;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

/**
 * @author Aliaksandr Miron
 */
public interface CatDao {

    List<Cat> getAll();

    Optional<Cat> getById(@NotNull final Long id);

    void create(@NotNull final Cat cat);

    void update(@NotNull final Long id, @NotNull final Cat cat);

    void delete(@NotNull final Long id);
}
