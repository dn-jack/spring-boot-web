package com.dongnao.jack.service;

import com.dongnao.jack.bean.User;

public interface UserService {
    public User findUserByName(String username);
}
