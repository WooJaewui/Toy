package com.example.login.controller;

import com.example.login.dto.LoginDto;
import com.example.login.dto.UserDto;
import com.example.login.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(LoginDto loginDto, HttpSession session, Model model) {
        UserDto user = new UserDto(loginDto.getUsername(), "TEST");

        session.setAttribute("user", user);
        model.addAttribute("username", loginDto.getUsername());
        System.out.println(session.getId());

        return "main";
    }

    @GetMapping("/logout")
    public String logout(UserDto userDto, HttpSession session, Model model) {
        System.out.println(session.getId().trim());
        final UserDto user = userService.getSessionAttribute(session.getId().trim(), "user");
        System.out.println(user);

        session.invalidate();

        return "redirect:/";
    }
}
