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
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findUserByToken(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        paginationDTO.setPagination(totalCount, currentPage, size, totalPage);
        return paginationDTO;
    }
}
