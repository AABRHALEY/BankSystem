package com.cs545.zara.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
