package com.smartcampus.campusissue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartcampus.campusissue.model.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {
}