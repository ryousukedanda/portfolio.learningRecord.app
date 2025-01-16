package com.example.lrs.domain.learningRecord;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LearningRecordService {
    //DI
    private final LearningRecordRepository learningRecordRepository;

    //学習記録リスト表示
    public List<LearningRecordEntity> showList() {
        return learningRecordRepository.showList();
    }

    //学習記録登録
    public void createList(LearningRecordForm learningRecordform){
        learningRecordRepository.createList(learningRecordform);
    }
}
