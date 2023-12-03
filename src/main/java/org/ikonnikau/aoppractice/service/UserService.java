package org.ikonnikau.aoppractice.service;

import lombok.extern.slf4j.Slf4j;
import org.ikonnikau.aoppractice.entity.User;
import org.ikonnikau.aoppractice.repository.UserRepository;
import org.ikonnikau.aoppractice.util.CustomResponse;
import org.ikonnikau.aoppractice.util.CustomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CustomResponse<User> getAll() {
        List<User> users = userRepository.findAll();
        return new CustomResponse<>(users, CustomStatus.SUCCESS);
    }

    public CustomResponse<User> getUserByFirstName(String firstName) {
        User user = userRepository.findFirstByFirstName(firstName).orElseThrow();
        return new CustomResponse<>(List.of(user), CustomStatus.SUCCESS);
    }

    public CustomResponse<User> addUser(User user) {
        User newUser = userRepository.save(user);
        return new CustomResponse<>(List.of(newUser), CustomStatus.SUCCESS);
    }
}
