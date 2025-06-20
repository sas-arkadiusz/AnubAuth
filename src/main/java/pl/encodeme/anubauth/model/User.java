package pl.encodeme.anubauth.model;

import lombok.Builder;

// @TODO: Add models for Username, Email, Password, and Role
@Builder
public record User(UserId id,
                   String username,
                   String email,
                   String password,
                   String role) {
}
