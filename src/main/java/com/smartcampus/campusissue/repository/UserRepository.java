package com.smartcampus.campusissue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartcampus.campusissue.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}