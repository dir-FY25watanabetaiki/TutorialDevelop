package com.dirbato.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dirbato.entity.User;
import com.dirbato.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /** 全件を検索して返す */
    public List<User> getUserList() {
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }
}