package com.study.shoppingmall.domain.order;

import com.study.shoppingmall.domain.delivery.Delivery;
import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    private Product product;

    @OneToOne
    private Delivery delivery;
}
