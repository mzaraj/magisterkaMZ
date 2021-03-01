package com.pl.mz.userservice.Controller;

import com.pl.mz.userservice.Entity.UserEntity;
import com.pl.mz.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userService.getAlllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody UserEntity userEntity){
        UserEntity createdUser = userService.addNewUser(userEntity);
        if(createdUser == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        if(userService.deleteUser(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@RequestBody UserEntity incomingUser,@PathVariable Long id){
        UserEntity editedUser = userService.editUser(incomingUser,id);
        if(editedUser != null)
            return ResponseEntity.ok(editedUser);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/init")
    public ResponseEntity<Void> initDB() {
        if (userService.initUsers())
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
