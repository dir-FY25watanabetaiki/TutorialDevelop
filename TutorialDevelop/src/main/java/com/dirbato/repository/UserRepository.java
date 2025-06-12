package com.dirbato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dirbato.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}