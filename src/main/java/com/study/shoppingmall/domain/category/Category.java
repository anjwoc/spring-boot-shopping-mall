package com.study.shoppingmall.domain.category;

import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.dto.BooleanToActiveConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String categoryCode;

    @Column(length = 20)
    private String categoryName;

    @Column
    private Integer depth;

    @Column
    @Convert(converter = BooleanToActiveConverter.class)
    private Boolean active;
}
