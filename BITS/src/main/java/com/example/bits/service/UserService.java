package com.example.bits.service;

import com.example.bits.model.Role;
import com.example.bits.model.User;
import com.example.bits.repository.RoleRepository;
import com.example.bits.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void registerDefaultUser(User user) {
        Role roleUser = roleRepository.findByName("Student");
        user.addRole(roleUser);

        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

}
