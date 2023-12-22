package com.study.shoppingmall.domain.review;


import com.study.shoppingmall.common.BaseTimeEntity;
import com.study.shoppingmall.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Review(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
