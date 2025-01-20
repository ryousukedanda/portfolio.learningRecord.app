package com.example.lrs.domain.learningRecord;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LearningRepository {
    //一覧表示
    @Select("select * from learning")
    List<LearningEntity> showList();

    //学習記録登録
    @Insert("insert into learning (learningDate, learningContent, learningTime, impression) " +
            "values (#{learningDate}, #{learningContent}, #{learningTime}, #{impression})")
    void insert(LearningEntity learningEntity);

    //編集画面表示
    @Select("select * from learning where id=#{id}")
    LearningEntity showEdit(long id);

    //更新
    @Update("update learning set learningDate = #{learningDate}, learningContent = #{learningContent}, " +
            "learningTime = #{learningTime}, impression = #{impression} where id = #{id}")
    void update(LearningEntity learningEntity);

    //削除
    @Delete("delete from learning where id = #{id}")
    void delete(long id);




}
