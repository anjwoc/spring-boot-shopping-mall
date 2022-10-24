package com.study.shoppingmall.domain.review;

import com.study.shoppingmall.domain.review.dto.ReviewSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long save(ReviewSaveRequestDto requestDto) {
        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    public List<Review> findByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<Review> findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}
