package com.wzvtc.project.community.mapper;

import com.wzvtc.project.community.dto.QuestionQueryDTO;
import com.wzvtc.project.community.model.Question;
import org.apache.ibatis.annotations.*;
import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.SunHints;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modify,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModify},#{creator},#{tag})")
    void createQuestion(Question question);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question order by gmt_create desc limit #{offset},#{size}")
    List<Question> listQuestion(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select * from question where creator=#{userId} limit #{offset},#{size} ")
    List<Question> listQuestionById(@Param("userId")Integer userId, @Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select * from question where id = #{id}")
    Question getQuestionById(@Param("id") Integer id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modify = #{gmtModify}, tag = #{tag} where id = #{id}")
    void updateQuestion(Question question);

    @Update("update question set view_count = #{viewCount} where id = #{id}")
    void updateView(Question question);

    @Update("update question set comment_count = #{commentCount} where id = #{id}")
    void updateComment(Question question);

    @Select("select * from question where id!=#{id} and tag regexp #{tag}")
    List<Question> selectRelated(Question question);

    @Select("select count(*) from question where title regexp #{search} or tag regexp #{search}")
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    @Select("select * from question where tag regexp #{search} or title regexp #{search} order by gmt_create limit #{page},#{size}")
    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
