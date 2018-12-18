package com.ly.myserver.service;

import com.ly.myserver.dao.UserDao;
import com.ly.myserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ying
 * @date 2018-12-18 19:34
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
