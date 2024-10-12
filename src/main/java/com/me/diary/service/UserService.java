package com.me.diary.service;

import com.me.diary.domain.model.User;

public interface UserService {
    User getUserById(Long id);

    User createUser(User user);
}
