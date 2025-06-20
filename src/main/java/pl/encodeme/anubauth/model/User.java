package pl.encodeme.anubauth.model;

import lombok.Builder;

import java.util.List;

// @TODO: Add models for Username, Email, Password, and Role
@Builder
public record User(UserId id,
                   String username,
                   String email,
                   String password,
                   List<String> roles) {
}
