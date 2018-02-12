package com.springboard.project.repository;

import com.springboard.project.domain.User;

public interface UserRepository {

    User create(User user);
    User findByEmailAndPassword(String email, String password);

}
