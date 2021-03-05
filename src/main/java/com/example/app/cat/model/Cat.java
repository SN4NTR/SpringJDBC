package com.example.app.cat.model;

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
public class Cat {

    private Long id;

    private String name;

    private LocalDate dateOfBirth;
}
