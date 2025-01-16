package com.example.lrs.domain.learningRecord;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LearningRecordRepository{

    @Select("select * from learning")
    List<LearningRecordEntity> showList();

}
