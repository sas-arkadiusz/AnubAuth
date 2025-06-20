package pl.encodeme.anubauth.model;

import lombok.Builder;

import java.util.List;

// @TODO: Add models for Username, Email, Password, and Role
@Builder
public record User(UserId userId,
                   String username,
                   String email,
                   String password,
                   List<String> roles) {

    public User withEncryptedPassword(String encryptedPassword) {
        return new User(userId, username, email, encryptedPassword, roles);
    }
}
