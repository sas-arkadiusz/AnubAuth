package pl.encodeme.anubauth.model;

// @TODO: Add models for Username, Email, Password, and Role
public record User(UserId id,
                   String username,
                   String email,
                   String password,
                   String role) {
}
