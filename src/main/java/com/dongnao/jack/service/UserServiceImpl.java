package com.dongnao.jack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnao.jack.bean.User;
import com.dongnao.jack.dao.UserMapper;
import com.dongnao.jack.dynamicDataSource.TargetDataSource;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserMapper userMapper;
    
    @TargetDataSource(name = "ds1")
    public User findUserByName(String username) {
        List<User> users = userMapper.findByUserName(username);
        return users.size() > 0 ? users.get(0) : null;
    }
    
}
