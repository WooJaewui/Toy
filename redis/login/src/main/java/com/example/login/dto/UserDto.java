package com.example.login.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@ToString
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1223478234324L;
    private String username;
    private String grade;

    public UserDto(final String username, final String grade) {
        this.username = username;
        this.grade = grade;
    }
}
