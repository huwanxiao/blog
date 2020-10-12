package com.wzvtc.project.community.service;

import com.wzvtc.project.community.dto.PaginationDTO;
import com.wzvtc.project.community.dto.QuestionDTO;
import com.wzvtc.project.community.dto.QuestionQueryDTO;
import com.wzvtc.project.community.mapper.QuestionMapper;
import com.wzvtc.project.community.mapper.UserMapper;
import com.wzvtc.project.community.model.Question;
import com.wzvtc.project.community.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO listQuestion(String search, Integer currentPage, Integer size) {
        List<Question> questions;
        if(StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, "+");
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }
        PaginationDTO paginationDTO = new PaginationDTO();

        //定义分页变量
        Integer totalPage;
        Integer totalCount;

        //参数容错，currentPage
        if(currentPage < 1) currentPage = 1;


        //获取offset
        Integer offset = size * (currentPage - 1 );
        //获取offset之后存入对象

        List<QuestionDTO> questionDTOS = new ArrayList<>();

        //获取问题列表questions和数量totalPage
        if(StringUtils.isNotBlank(search)) {
            //定义questionQueryDTO变量
            QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
            questionQueryDTO.setSearch(search);
            questionQueryDTO.setSize(size);
            questionQueryDTO.setPage(offset);
            totalCount = questionMapper.countBySearch(questionQueryDTO);
            questions = questionMapper.selectBySearch(questionQueryDTO);
        }else {
            totalCount = questionMapper.count();
            questions = questionMapper.listQuestion(offset, size);
        }

        //计算totalpage
        if(totalCount % size == 0) {
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }

        if(currentPage > totalPage) currentPage = totalPage;

        for (Question question : questions) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setData(questionDTOS);
        paginationDTO.setPagination(currentPage,totalPage);
        return paginationDTO;
    }

    public PaginationDTO listQuestionById(Integer userId, Integer currentPage, Integer size) {

        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO();

        //获取问题总量
        Integer totalPage = 0;
        Integer totalCount = questionMapper.count();

        //计算totalpage
        if(totalCount % size == 0) {
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }

        //参数容错
        if(currentPage < 1) currentPage = 1;
        if(currentPage > totalPage) currentPage = totalPage;

        Integer offset = size * (currentPage - 1 );
        List<Question> questions = questionMapper.listQuestionById(userId, offset, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setData(questionDTOS);
        paginationDTO.setPagination( currentPage, totalPage);
        return paginationDTO;
    }

    public QuestionDTO getQuestionById(Integer id) {
        Question question = questionMapper.getQuestionById(id);
        QuestionDTO questionDTO = new QuestionDTO();

        User user = userMapper.findUserById(question.getCreator());
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null) {
            //创建
            questionMapper.createQuestion(question);
        } else {
            //更新
            questionMapper.updateQuestion(question);
        }
    }

    public void incViewOrLikeOrComment(String type,Integer id) {
        Question question = questionMapper.getQuestionById(id);
        if(type == "viewCount"){
            question.setViewCount(question.getViewCount() + 1);
            questionMapper.updateView(question);
        } else if(type == "commentCount"){
            question.setCommentCount(question.getCommentCount() + 1);
            questionMapper.updateComment(question);
        }
    }

    public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if(StringUtils.isBlank(queryDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regexpTag);

        List<Question> questions = questionMapper.selectRelated(question);
        List<QuestionDTO> questionDTOS = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q, questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOS;
    }
}
