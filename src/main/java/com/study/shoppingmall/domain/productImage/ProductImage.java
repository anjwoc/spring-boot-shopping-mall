package com.study.shoppingmall.domain.productImage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.dto.BooleanToActiveConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class ProductImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;

    @Column
    @Convert(converter = BooleanToActiveConverter.class)
    private Boolean defaultFlag;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;
}
