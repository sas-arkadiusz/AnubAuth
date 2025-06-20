package pl.encodeme.anubauth.user;

import pl.encodeme.anubauth.model.User;

public interface UserAuthRepository {
    User findByEmail(String email);
    User saveOrUpdate(User user);
}
