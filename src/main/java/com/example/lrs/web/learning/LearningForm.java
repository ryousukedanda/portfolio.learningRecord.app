package com.example.lrs.web.learning;


import com.example.lrs.domain.learningRecord.LearningEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class LearningForm {

    private long id;

    @NotNull//空白文字は許可
    private LocalDate learningDate;

    @NotBlank//入力必須
    @Size(max=1000)
    private String learningContent;

    @NotBlank//入力必須
    @Size(max=20)
    private String learningTime;

    @NotBlank//入力必須
    @Size(max=1000)
    private String impression;

}
