package pl.encodeme.anubauth.model;

import java.util.UUID;

public record UserId(UUID value) {

    public static UserId generateUserId() {
        return new UserId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
