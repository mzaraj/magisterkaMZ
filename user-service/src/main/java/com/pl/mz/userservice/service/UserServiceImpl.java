package com.pl.mz.userservice.service;

import com.pl.mz.userservice.Entity.UserApiHelper;
import com.pl.mz.userservice.Entity.UserEntity;
import com.pl.mz.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RestTemplate restTemplate;

    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<UserEntity> getAlllUsers() {
        List<UserEntity> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public UserEntity addNewUser(UserEntity newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public UserEntity editUser(UserEntity editingUser, Long id)  {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            editingUser.setId(id);
            userRepository.save(editingUser);
        }
        return editingUser;
    }

    @Override
    public boolean initUsers() {
        try {
            String url = "https://randomuser.me/api/?results=50&seed=marcin&nat=us&inc=name,email,login&noinfo";
            ResponseEntity<UserApiHelper> response = restTemplate.getForEntity(url, UserApiHelper.class);
            userRepository.saveAll(response.getBody().toUserList());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }

    }
}
