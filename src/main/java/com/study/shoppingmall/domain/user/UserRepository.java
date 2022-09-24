package com.study.shoppingmall.domain.user;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.shoppingmall.dto.QUserDto;
import com.study.shoppingmall.dto.UserDto;
import com.study.shoppingmall.dto.UserSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


import static com.study.shoppingmall.domain.user.QUser.user;
import static org.springframework.util.StringUtils.*;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public void delete(User user) {
        em.remove(user);
    }

    public Optional<User> findById(Long id) {
        BooleanBuilder builder = new BooleanBuilder();

        if (!hasText(id.toString())){
            builder.and(user.id.eq(id));
        }

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(user)
                        .where(builder)
                        .fetchOne()
        );
    }

    public Optional<User> findByUsername(String username) {
        BooleanBuilder builder = new BooleanBuilder();

        if (!hasText(username.toString())){
            builder.and(user.username.eq(username));
        }

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(user)
                        .where(builder)
                        .fetchOne()
        );
    }

    public List<UserDto> userList(UserSearchCondition condition) {
        return queryFactory
                .select(new QUserDto(
                        user.email,
                        user.username,
                        user.age,
                        user.address,
                        user.balance
                ))
                .from(user)
                .where(
                        usernameEq(condition.getUsername()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe()),
                        balanceGoe(condition.getBalanceGoe()),
                        balanceLoe(condition.getBalanceLoe())
                )
                .fetch();
    }

    private BooleanExpression usernameEq(String username){
        return hasText(username) ? user.username.eq(username) : null;
    }

    private BooleanExpression balanceGoe(Integer balance) {
        return balance != null ? user.balance.goe(balance) : null;
    }

    private BooleanExpression balanceLoe(Integer balance) {
        return balance != null ? user.balance.loe(balance) : null;
    }

    private BooleanExpression ageGoe(Integer age) {
        return age != null ? user.age.goe(age) : null;
    }

    private BooleanExpression ageLoe(Integer age){
        return age != null ? user.age.loe(age) : null;
    }

}
