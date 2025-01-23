package com.practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.practice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
