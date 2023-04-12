package com.shoptee.shoptee.service.serviceimpl;

import com.shoptee.shoptee.entity.Role;
import com.shoptee.shoptee.entity.User;
import com.shoptee.shoptee.repository.RoleRepository;
import com.shoptee.shoptee.repository.UserRepository;
import com.shoptee.shoptee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void registerDefaultUser(User user) {
        Role roleUser = roleRepository.findByName("User");
        user.addRole(roleUser);
        encodePassword(user);
        userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Role> listRole() {
        return roleRepository.findAll();
    }

    @Override
    public void save(User user) {
        encodePassword(user);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void encodePassword(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }
}
