package com.example.app.cat.service;

import com.example.app.cat.dao.CatDao;
import com.example.app.cat.model.Cat;
import com.example.app.cat.model.converter.CatConverter;
import com.example.app.cat.model.dto.CatDto;
import com.example.app.core.exception.EntityNotFoundException;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliaksandr Miron
 */
@AllArgsConstructor
@Validated
@Service
public class CatServiceImpl implements CatService {

    private final CatDao catDao;
    private final CatConverter catConverter;

    @Override
    public List<CatDto> getAll() {
        final List<Cat> cats = catDao.getAll();
        return catConverter.toDtoList(cats);
    }

    @Override
    public CatDto getById(@NotNull final Long id) {
        final Cat cat = catDao.getById(id).orElseThrow(EntityNotFoundException::new);
        return catConverter.toDto(cat);
    }

    @Override
    public void create(@NotNull final CatDto catDto) {
        final Cat cat = catConverter.fromDto(catDto);
        catDao.create(cat);
    }

    @Override
    public void update(@NotNull final Long id, @NotNull final CatDto catDto) {
        final Cat cat = catConverter.fromDto(catDto);
        catDao.update(id, cat);
    }

    @Override
    public void delete(@NotNull final Long id) {
        catDao.delete(id);
    }
}
