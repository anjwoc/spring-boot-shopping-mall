package com.study.shoppingmall.domain.product;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.util.Optional;

import static com.study.shoppingmall.domain.product.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    public Product delete(Product product) {
        em.remove(product);
        return product;
    }

    public Optional<Product> findById(Long id) {

        BooleanBuilder builder = new BooleanBuilder();

        if (!StringUtils.hasText(id.toString())){
            builder.and(product.id.eq(id));
        }

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(product)
                        .where(builder)
                        .fetchFirst()
        );
    }

}
