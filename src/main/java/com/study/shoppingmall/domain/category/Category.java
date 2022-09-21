package com.study.shoppingmall.domain.category;

import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.dto.BooleanToActiveConverter;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "categorys")
@Entity
@Getter
@Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<Product>();

    @Column
    private Boolean active;
}
