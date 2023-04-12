package com.shoptee.shoptee.service;

import com.shoptee.shoptee.entity.Role;
import com.shoptee.shoptee.entity.User;

import java.util.List;

public interface UserService {
    void registerDefaultUser(User user);
    List<User> listAll();
    User get(Long id);
    List<Role> listRole();
    void save(User user);
    void delete(Long id);
}
