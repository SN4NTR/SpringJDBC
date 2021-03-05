package com.example.app.cat.service;

import com.example.app.cat.model.Cat;
import com.example.app.cat.model.dto.CatDto;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * @author Aliaksandr Miron
 */
public interface CatService {

    List<CatDto> getAll();

    CatDto getById(@NotNull final Long id);

    void create(@NotNull final CatDto catDto);

    void update(@NotNull final Long id, @NotNull final CatDto catDto);

    void delete(@NotNull final Long id);
}
