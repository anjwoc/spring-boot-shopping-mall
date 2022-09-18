package com.study.shoppingmall.domain.user;

import com.study.shoppingmall.dto.UserDto;
import com.study.shoppingmall.dto.UserRequestDto;
import com.study.shoppingmall.dto.UserSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public List<UserDto> userList(UserSearchCondition condition) {
        return userRepository.userList(condition);
    }


    @Transactional
    public Long save(UserRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID=" + id));

        userRepository.delete(user);
    }
}
