package com.cs545.zara.service;

import com.cs545.zara.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
