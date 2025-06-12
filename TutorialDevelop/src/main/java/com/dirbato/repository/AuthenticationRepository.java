package com.dirbato.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dirbato.entity.Authentication;
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {
}