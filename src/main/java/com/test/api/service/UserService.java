package com.test.api.service;

import com.test.api.entity.User;
import com.test.api.entity.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<UserResponse> findAll();
}
