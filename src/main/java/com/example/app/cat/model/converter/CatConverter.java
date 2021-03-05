package com.example.app.cat.model.converter;

import static java.util.stream.Collectors.toList;

import com.example.app.cat.model.Cat;
import com.example.app.cat.model.dto.CatDto;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliaksandr Miron
 */
@Validated
@Component
public class CatConverter {

    public CatDto toDto(@NotNull final Cat cat) {
        final CatDto catDto = new CatDto();
        catDto.setName(cat.getName());
        catDto.setDateOfBirth(cat.getDateOfBirth());
        return catDto;
    }

    public List<CatDto> toDtoList(@NotNull final List<Cat> cats) {
        return cats.stream()
                .map(this::toDto)
                .collect(toList());
    }

    public Cat fromDto(@NotNull final CatDto catDto) {
        final Cat cat = new Cat();
        cat.setName(catDto.getName());
        cat.setDateOfBirth(catDto.getDateOfBirth());
        return cat;
    }

    public List<Cat> fromDtoList(@NotNull final List<CatDto> catDtoList) {
        return catDtoList.stream()
                .map(this::fromDto)
                .collect(toList());
    }
}
