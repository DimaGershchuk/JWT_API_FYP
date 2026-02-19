package com.example.JWT_API.Controller;

import com.example.JWT_API.DTO.UserUpdate;
import com.example.JWT_API.Entity.User;
import com.example.JWT_API.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();

        return userService.getCurrentUser(username);
    }

    @PutMapping("/update-details")
    public ResponseEntity<User> updateProfile(@RequestBody UserUpdate dto, Authentication authentication){
        String username = authentication.getName();

        User updatedUser = userService.updateUserDetails(username, dto);

        return ResponseEntity.ok(updatedUser);
    }


}