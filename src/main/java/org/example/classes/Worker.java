package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {

    private String name;

    private String surnames;

    private String birth_date;

    private String position;

    private Schedule schedule;
}
