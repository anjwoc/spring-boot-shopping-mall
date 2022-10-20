package com.study.shoppingmall.domain.review;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findById(Long id);

    List<Review> findByUserId(Long userId);

    List<Review> findByProductId(Long productId);
}
