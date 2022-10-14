package com.ej7.crudvalidation.students.infrastructure.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDtoIn {

    private String person_id;
    private String teacher_id;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    private List<String> subjectsList= new ArrayList<>();
}
