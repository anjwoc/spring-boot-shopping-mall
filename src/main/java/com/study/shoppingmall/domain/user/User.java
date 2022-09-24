package com.study.shoppingmall.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.shoppingmall.common.BaseTimeEntity;
import com.study.shoppingmall.domain.enums.UserRole;
import com.study.shoppingmall.domain.order.Order;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Table(name = "users")
@Entity
@Getter
@Setter
@DynamicInsert
@Builder @AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private Integer age;

    @Column
    private String password;

    @Column
    private String address;

    @ColumnDefault("USER")
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column
    @ColumnDefault("0")
    private Integer balance;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;

    public User hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }

    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(plainPassword, this.password);
    }

    public List<String> getRoleList() {
        return Stream.of(UserRole.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}

