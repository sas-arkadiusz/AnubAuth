package pl.encodeme.anubauth.user;

import pl.encodeme.anubauth.model.User;

import java.util.Optional;

public interface UserProvider {
    Optional<User> findByEmail(String email);
    User saveOrUpdate(User user);
}
