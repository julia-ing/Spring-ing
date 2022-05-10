package com.efub.tdd.repository;

import com.efub.tdd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

