package com.ruoyi.bus.service.impl;

import com.ruoyi.bus.mapper.UserMapper;
import com.ruoyi.bus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<String> getRoleName(int id) {
        return userMapper.selectRoleName(id);
    }
}
