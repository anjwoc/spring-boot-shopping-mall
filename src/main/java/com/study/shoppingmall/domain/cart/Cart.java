package com.study.shoppingmall.domain.cart;

import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Table(name = "carts")
@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer productCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;



}
