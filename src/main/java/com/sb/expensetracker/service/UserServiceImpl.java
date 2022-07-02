package com.sb.expensetracker.service;

import com.sb.expensetracker.entity.User;
import com.sb.expensetracker.repository.UserRepository;
import com.sb.expensetracker.util.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) {
        log.info(" ");
        Optional<User> user1 = userRepository.findByEmail(userDto.getEmail());
        if (user1.isPresent())
            throw new RuntimeException("user already exist with this email!");

        User user = User.builder()
                .name(userDto.getName())
                .password((userDto.getPassword()))
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .build();

        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        log.info(" ");
        userRepository.deleteById(id);
        return "Succesfully Deleted!";
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        log.info(" ");
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User user1 = User.builder()
                    .name(userDto.getName() != null ? userDto.getName() : user.get().getName())
                    .password(userDto.getPassword() != null ? userDto.getPassword() : user.get().getPassword())
                    .age(userDto.getAge() != null ? userDto.getAge() : user.get().getAge())
                    .email(userDto.getPassword() != null ? userDto.getPassword() : user.get().getEmail())
                    .build();
            return userRepository.save(user1);
        } else
            throw new RuntimeException("user not exist with this id!");
    }

    @Override
    public User getUser(Long id) {
        log.info("");
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("user is not present with this id!");
    }
}
