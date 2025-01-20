package com.example.lrs.domain.learningRecord;

import com.example.lrs.web.learning.LearningForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LearningService {

    private final LearningRepository learningRepository;

    //一覧表示
    public List<LearningEntity> showList(){
        return learningRepository.showList();
    }
    //登録
    @Transactional
    public void createList(LearningEntity learningEntity){
        learningRepository.insert(learningEntity);
    }

    //編集画面表示
    public LearningEntity showEdit(long id) {
        return learningRepository.showEdit(id);
    }

    //更新
    public void update(LearningEntity learningEntity){
        learningRepository.update(learningEntity);
    }
    //削除
    public void delete(long id) {
        learningRepository.delete(id);
    }
}
