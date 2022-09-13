package com.study.shoppingmall.domain.product;

import com.study.shoppingmall.domain.category.Category;
import com.study.shoppingmall.domain.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String productName;

    @Column
    private Integer price;

    @Column
    private Integer purchaseCount;

    @Column
    private Integer stockQuantity;

    @Column
    private Category productCategory;
}
