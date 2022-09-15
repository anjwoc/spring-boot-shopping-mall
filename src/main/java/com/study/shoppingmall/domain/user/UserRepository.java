package com.study.shoppingmall.domain.user;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private JPAQueryFactory queryFactory;
    QUser user = new QUser("user");
    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public void delete(User user) {
        em.remove(user);
    }

    public Optional<User> findById(Long id) {
        BooleanBuilder builder = new BooleanBuilder();

        if (!StringUtils.hasText(id.toString())){
            builder.and(user.id.eq(id));
        }

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(user)
                        .where(builder)
                        .fetchOne()
        );
    }

}
