package com.study.shoppingmall.domain.user;

import com.study.shoppingmall.dto.ResponseDto;
import com.study.shoppingmall.dto.UserDto;
import com.study.shoppingmall.dto.UserRequestDto;
import com.study.shoppingmall.dto.UserSearchCondition;
import com.study.shoppingmall.utils.ResponseUtil;
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
    public ResponseDto save(@RequestBody UserRequestDto requestDto) {
        Long joinedUser = userService.join(requestDto);

        return ResponseUtil.SUCCESS("회원가입이 되었습니다.", joinedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
