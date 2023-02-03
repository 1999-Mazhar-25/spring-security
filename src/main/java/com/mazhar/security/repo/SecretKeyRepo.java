package com.mazhar.security.repo;

import com.mazhar.security.entity.SecretKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretKeyRepo extends JpaRepository<SecretKey,Integer> {

    Optional<SecretKey> findByUsername(String username);
}
