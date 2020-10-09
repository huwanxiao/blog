package com.wzvtc.project.community.service;

import com.wzvtc.project.community.dto.PaginationDTO;
import com.wzvtc.project.community.dto.QuestionDTO;
import com.wzvtc.project.community.mapper.QuestionMapper;
import com.wzvtc.project.community.mapper.UserMapper;
import com.wzvtc.project.community.model.Question;
import com.wzvtc.project.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO listQuestion(Integer currentPage, Integer size) {

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
        List<Question> questions = questionMapper.listQuestion(offset, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

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
}
