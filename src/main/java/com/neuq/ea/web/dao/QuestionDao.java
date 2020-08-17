package com.neuq.ea.web.dao;

import com.neuq.ea.ao.QuestionAO;
import com.neuq.ea.ao.QuestionPageAO;
import com.neuq.ea.domain.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Repository
public interface QuestionDao {

    @Insert("<script>insert into question (name, content, type, " +
            "<if test=\" examinationPaperId != 0 \">examination_paper_id,</if>" +
            " `desc`, score, ctime, utime) value (#{name}, #{content}, #{type}, " +
            "<if test=\" examinationPaperId != 0 \">#{examinationPaperId},</if>" +
            "#{desc}, #{score}, UNIX_TIMESTAMP(), UNIX_TIMESTAMP())</script>")
    boolean save(QuestionAO questionAO);

    @Update("<script>update question set name=#{name}, content=#{content}, type=#{type}," +
            "<if test=\" examinationPaperId != 0 \">examination_paper_id=#{examinationPaperId},</if>" +
            " `desc` = #{desc}, score=#{score}, utime=UNIX_TIMESTAMP() where id=#{id} </script>")
    boolean update(QuestionAO questionAO);


    @Select("<script>select * from question where 1=1 " +
            "<if test=\" vo.keyWord != null and vo.keyWord != '' \">" +
            "<bind name=\"pattern\" value=\"'%' + vo.keyWord + '%'\" />" +
            "and (name like #{pattern} " +
            " or content like #{pattern} " +
            " or `desc` like #{pattern})</if>" +
            "<if test=\" vo.type != 0 \"> and type=#{vo.type}</if>" +
            "<if test=\" vo.examinationPaperId != 0 \"> " +
            " and examination_paper_id=#{vo.examinationPaperId}</if>" +
            "<if test=\" vo.maxScore &lt; 0 and vo.minScore &gt; vo.maxScore \"> " +
            " and #{vo.minScore}  &lt;= score and #{vo.maxScore} &gt;= score </if>" +
            " order by utime desc limit #{offset}, #{size}</script>")
    List<Question> pageList(@Param("vo") QuestionPageAO questionPageAO, @Param("offset") int offset, @Param("size") int size);

    @Select("<script>select count(0) from question where 1=1 " +
            "<if test=\" vo.keyWord != null and vo.keyWord != '' \">" +
            "<bind name=\"pattern\" value=\"'%' + vo.keyWord + '%'\" />" +
            "and (name like #{pattern} " +
            " or content like #{pattern} " +
            " or `desc` like #{pattern})</if>" +
            "<if test=\" vo.type != 0 \"> and type=#{vo.type}</if>" +
            "<if test=\" vo.examinationPaperId != 0 \"> " +
            " and examination_paper_id=#{vo.examinationPaperId}</if>" +
            "<if test=\" vo.maxScore &lt; 0 and vo.minScore &gt; vo.maxScore \"> " +
            " and #{vo.minScore}  &lt;= score and #{vo.maxScore} &gt;= score </if>" +
            "</script>")
    int pageCount(@Param("vo") QuestionPageAO questionPageAO);
}
