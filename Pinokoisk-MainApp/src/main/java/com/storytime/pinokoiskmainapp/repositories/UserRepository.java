package com.storytime.pinokoiskmainapp.repositories;


import com.storytime.pinokoiskmainapp.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
