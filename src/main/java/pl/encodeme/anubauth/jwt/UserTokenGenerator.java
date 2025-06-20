package pl.encodeme.anubauth.jwt;

import pl.encodeme.anubauth.model.User;

public interface UserTokenGenerator {
    String generateToken(User user);
}
