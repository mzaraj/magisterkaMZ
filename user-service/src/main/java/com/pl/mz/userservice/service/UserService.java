package com.pl.mz.userservice.service;

import com.pl.mz.userservice.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> getUserById(Long userId);

    List<UserEntity> getAlllUsers();

    UserEntity addNewUser(UserEntity newUser);

    boolean deleteUser(Long userID);

    UserEntity editUser(UserEntity editingUser, Long id);

    boolean initUsers();
}
