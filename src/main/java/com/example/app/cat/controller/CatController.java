package com.example.app.cat.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.example.app.cat.model.Cat;
import com.example.app.cat.model.dto.CatDto;
import com.example.app.cat.service.CatService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliaksandr Miron
 */
@Slf4j
@RequestMapping("/cats")
@AllArgsConstructor
@RestController
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<CatDto> getAll() {
        log.info("Getting all cats.");

        return catService.getAll();
    }

    @GetMapping("/{id}")
    public CatDto getById(@PathVariable final Long id) {
        log.info("Getting cat with id = {}.", id);

        return catService.getById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void create(@RequestBody final CatDto catDto) {
        log.info("Creating cat [{}].", catDto);

        catService.create(catDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable final Long id, @RequestBody final CatDto catDto) {
        log.info("Updating cat with id = {}, [{}].", id, catDto);

        catService.update(id, catDto);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        log.info("Deleting cat with id = id.");

        catService.delete(id);
    }
}
