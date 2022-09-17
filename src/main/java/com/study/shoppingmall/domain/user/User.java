package com.study.shoppingmall.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.shoppingmall.domain.common.BaseTimeEntity;
import com.study.shoppingmall.domain.order.Order;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String authorities;

    @Column
    @ColumnDefault("0")
    private Integer savings;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;

}

