package com.shree.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shree.user.service.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
