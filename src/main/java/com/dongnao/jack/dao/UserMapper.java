package com.dongnao.jack.dao;

import java.util.List;

import com.dongnao.jack.bean.User;

public interface UserMapper {
    
    List<User> findByUserName(String username);
}
