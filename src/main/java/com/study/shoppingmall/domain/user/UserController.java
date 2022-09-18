package com.study.shoppingmall.domain.user;

import com.study.shoppingmall.dto.UserDto;
import com.study.shoppingmall.dto.UserRequestDto;
import com.study.shoppingmall.dto.UserSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findUser(id)
                .orElse(null);
    }

    @GetMapping("")
    public List<UserDto> getUserList(UserSearchCondition condition) {
        return userService.userList(condition);
    }

    @PostMapping("")
    public Long save(@RequestBody UserRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
