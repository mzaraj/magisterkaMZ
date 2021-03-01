package com.pl.mz.userservice.Entity;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserApiHelper {

        Person[] results;

        public List<UserEntity> toUserList() {
            return Arrays.stream(results)
                    .map(p -> new UserEntity(p.getName().getFirst(), p.getName().getLast(), p.getEmail(), p.getLogin().getPassword()))
                    .collect(Collectors.toList());
        }

        @Data
        static class Person {
            private Name name;
            private String email;
            private Login login;
        }

        @Data
        static class Name {
            private String first;
            private String last;
        }

        @Data
        static class Login {
            private String password;
        }
}
