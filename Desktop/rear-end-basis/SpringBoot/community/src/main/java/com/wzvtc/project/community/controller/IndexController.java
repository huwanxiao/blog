package com.wzvtc.project.community.controller;

import com.wzvtc.project.community.dto.PaginationDTO;
import com.wzvtc.project.community.mapper.QuestionMapper;
import com.wzvtc.project.community.mapper.UserMapper;
import com.wzvtc.project.community.model.User;
import com.wzvtc.project.community.service.QuestionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "size" ,defaultValue = "5") Integer size,
                        @RequestParam(name = "search", required = false) String search
    ) {

        PaginationDTO pagination = questionService.listQuestion(search,currentPage,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("search",search);
        return "index";
    }
}
