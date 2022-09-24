package com.study.shoppingmall.domain.qna;

import com.study.shoppingmall.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnA extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // 비밀글 패스워드
    private String password;

    // 문의 게시글 작성자(회원이 아니여도 작성 가능)
    private String writer;

    // 문의 게시글 내용
    @Lob
    private String content;


//    private Category category;
}
