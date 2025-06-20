package pl.encodeme.anubauth.model;

import lombok.Builder;

import java.util.List;

@Builder
public record User(UserId userId,
                   String username,
                   String email,
                   String password,
                   List<String> roles) {
}
