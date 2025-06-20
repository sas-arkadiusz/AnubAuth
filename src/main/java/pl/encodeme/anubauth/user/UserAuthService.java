package pl.encodeme.anubauth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.encodeme.anubauth.model.User;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserAuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(User user) {
        userRepository.saveOrUpdate(user.withEncryptedPassword(passwordEncoder.encode(user.password())));
    }
}
