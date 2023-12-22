package com.study.shoppingmall.domain.review.dto;

import com.study.shoppingmall.domain.review.Review;
import com.study.shoppingmall.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class ReviewSaveRequestDto {
    private String title;
    private String content;
    private User user;

    @Builder
    public ReviewSaveRequestDto(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Review toEntity() {
        return Review.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}