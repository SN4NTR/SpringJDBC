package com.example.app.cat.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aliaksandr Miron
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatDto {

    private String name;

    private LocalDate dateOfBirth;
}
