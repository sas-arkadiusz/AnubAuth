package pl.encodeme.anubauth.user;

import org.springframework.stereotype.Repository;
import pl.encodeme.anubauth.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
class InMemoryUserAuthRepository implements UserAuthRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

    @Override
    public User saveOrUpdate(User user) {
        users.put(user.email(), user);
        return user;
    }
}
