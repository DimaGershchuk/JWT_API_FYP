package com.example.JWT_API.Repository;

import com.example.JWT_API.Entity.RefreshToken;
import com.example.JWT_API.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUser(User user);

    void deleteByUser(User user);
}
