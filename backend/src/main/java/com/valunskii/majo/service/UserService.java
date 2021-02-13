package com.valunskii.majo.service;

import com.valunskii.majo.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    User findById(Long id);
    User update(Long id, User user);
}
