package com.example.lrs.domain.learningRecord;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class LearningEntity {

    private long id;
    private LocalDate learningDate;
    private String learningContent;
    private String learningTime;
    private String impression;

}
