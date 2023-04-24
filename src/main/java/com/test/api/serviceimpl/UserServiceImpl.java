package com.test.api.serviceimpl;

import com.test.api.entity.User;
import com.test.api.entity.UserResponse;
import com.test.api.service.UserService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserResponse> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";
        List<User> users = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        ).getBody();
        List<UserResponse> userList = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse = userResponse.builder().id(user.getId()).userName(user.getUsername())
                    .email(user.getEmail()).companyName(user.getCompany().getName())
                    .lat(user.getAddress().getGeo().getLat()).lng(user.getAddress().getGeo().getLng()).build();
            userList.add(userResponse);
        }
        return userList;
    }
}
