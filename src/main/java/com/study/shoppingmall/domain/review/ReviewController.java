package com.study.shoppingmall.domain.review;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{userId}/user")
    public List<Review> findByUserId(@PathVariable Long userId) {
        return reviewService.findByUserId(userId);
    }

    @GetMapping("/{productId}/product")
    public List<Review> findByProductId(@PathVariable Long productId) {
        return reviewService.findByUserId(productId);
    }
}
