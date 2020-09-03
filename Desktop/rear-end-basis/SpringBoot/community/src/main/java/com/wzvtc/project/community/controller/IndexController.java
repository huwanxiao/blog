package com.wzvtc.project.community.controller;

import com.wzvtc.project.community.dto.PaginationDTO;
import com.wzvtc.project.community.dto.QuestionDTO;
import com.wzvtc.project.community.mapper.QuestionMapper;
import com.wzvtc.project.community.mapper.UserMapper;
import com.wzvtc.project.community.model.Question;
import com.wzvtc.project.community.model.User;
import com.wzvtc.project.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
                        @RequestParam(name = "page",defaultValue = "1") Integer currentpage,
                        @RequestParam(name = "size" ,defaultValue = "5") Integer size
    ) {
        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("token")) {
                token = cookie.getValue();
                User user = userMapper.findUserByToken(token);
                if(user != null) {
                    request.getSession().setAttribute("user",user);
                    System.out.println(request.getSession().getAttribute("user"));
                }
                break;
            }
        }

        PaginationDTO pagination = questionService.listQuestion(currentpage,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
