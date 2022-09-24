package com.study.shoppingmall.domain.order;

import com.study.shoppingmall.common.BaseTimeEntity;
import com.study.shoppingmall.domain.delivery.Delivery;
import com.study.shoppingmall.domain.enums.OrderStatus;
import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.domain.user.User;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "orders")
@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderNumber;

    @Column
    private String deliveryMessage;

    @Column
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    private Product product;

    @OneToOne
    private Delivery delivery;
}
