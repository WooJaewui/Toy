package com.example.login.repository;

import com.example.login.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDto, String> {
}
