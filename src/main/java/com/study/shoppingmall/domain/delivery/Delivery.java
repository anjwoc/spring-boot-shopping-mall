package com.study.shoppingmall.domain.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.shoppingmall.domain.enums.DeliveryStatus;
import com.study.shoppingmall.domain.order.Order;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
