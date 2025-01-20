package com.example.lrs.web.learning;

import com.example.lrs.domain.learningRecord.LearningEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LearningMapper {

    // マッパーインスタンスの取得
    LearningMapper INSTANCE = Mappers.getMapper(LearningMapper.class);

    // LearningForm -> LearningEntity へのマッピング
    LearningEntity toEntity(LearningForm form);

    // LearningEntity -> LearningForm へのマッピング
    LearningForm toForm(LearningEntity entity);
}
