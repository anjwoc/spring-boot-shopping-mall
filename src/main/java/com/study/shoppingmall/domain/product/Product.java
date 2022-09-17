package com.study.shoppingmall.domain.product;

import com.study.shoppingmall.domain.cart.Cart;
import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.domain.enums.ProductStatus;
import com.study.shoppingmall.domain.productImage.ProductImage;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "products")
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

    @Column(length = 20)
    private String categoryCode;

    // 상품 이름
    @Column(length = 200)
    private String productName;

    // 상품 가격
    @Column
    private Integer price;

    // 상품 구매 횟수
    @Column
    private Integer purchaseCount;

    // 상품 재고 개수
    @Column
    private Integer stockQuantity;

    // 상품 전체 수량
    @Column
    private Integer totalCount;

    @Column(length = 10)
    private ProductStatus productStatus;

    // 썸네일 URL
    @Column(length = 300)
    private String thumbnail;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Cart> cartList;


}
