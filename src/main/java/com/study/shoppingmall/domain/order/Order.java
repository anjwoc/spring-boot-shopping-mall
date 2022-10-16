package com.study.shoppingmall.domain.order;

import com.study.shoppingmall.common.BaseTimeEntity;
import com.study.shoppingmall.domain.delivery.Delivery;
import com.study.shoppingmall.domain.enums.OrderStatus;
import com.study.shoppingmall.domain.orderProduct.OrderProduct;
import com.study.shoppingmall.domain.product.Product;
import com.study.shoppingmall.domain.user.User;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Getter
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    private Product product;

    @OneToOne
    private Delivery delivery;
}
