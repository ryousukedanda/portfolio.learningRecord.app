package com.example.lrs.domain.learningRecord;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LearningRecordService {

    private final LearningRecordRepository learningRecordRepository;

    public List<LearningRecordEntity> showList(){
        return learningRecordRepository.showList();
    }
}
