package com.study.shoppingmall.domain.user;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInterface extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
