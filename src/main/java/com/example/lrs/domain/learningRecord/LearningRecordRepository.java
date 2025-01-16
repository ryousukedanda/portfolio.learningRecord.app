package com.example.lrs.domain.learningRecord;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LearningRecordRepository{
    //学習記録リスト表示
    @Select("select * from learning")
    List<LearningRecordEntity> showList();

    //学習記録登録
    @Insert("insert into learning (learningDate, learningContent, learningTime, impression) " +
            "VALUES (#{learningDate}, #{learningContent}, #{learningTime}, #{impression})")
    void createList(LearningRecordForm learningRecordform);

}
