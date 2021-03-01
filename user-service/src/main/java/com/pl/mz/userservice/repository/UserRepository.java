package com.pl.mz.userservice.repository;

import com.pl.mz.userservice.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
