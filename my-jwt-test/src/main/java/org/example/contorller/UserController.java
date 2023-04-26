package org.example.contorller;

import io.jsonwebtoken.Claims;
import org.example.dto.User;
import org.example.utils.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        } else {
            throw new RuntimeException("Invalid authorization header");
        }

        Claims claims = JwtUtils.parseToken(token);
        long userId = Long.parseLong(claims.getSubject());

        // TODO: Get user list
        List<User> users = new ArrayList<>();

        return users;
    }
}
