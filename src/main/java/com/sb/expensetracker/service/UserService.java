package com.sb.expensetracker.service;

import com.sb.expensetracker.entity.User;
import com.sb.expensetracker.util.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserDto userDto);

    String deleteUser(Long id);

    User updateUser(Long id, UserDto userDto);

    User getUser(Long id);
}
