package com.study.shoppingmall.domain.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.domain.enums.DeliveryStatus;
//import com.study.shoppingmall.domain.order.Order;
import com.study.shoppingmall.domain.order.Order;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "deliverys")
@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Delivery extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
