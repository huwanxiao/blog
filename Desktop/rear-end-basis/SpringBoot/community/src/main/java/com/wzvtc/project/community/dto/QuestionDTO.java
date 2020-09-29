package com.wzvtc.project.community.dto;

import com.wzvtc.project.community.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Integer creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private Long gmtCreate;
    private Long gmtModify;
    private String avatarUrl;
    private User user;
}

