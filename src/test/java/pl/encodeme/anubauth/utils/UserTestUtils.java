package pl.encodeme.anubauth.utils;

import net.bytebuddy.utility.RandomString;
import pl.encodeme.anubauth.model.User;
import pl.encodeme.anubauth.model.UserId;

import java.util.List;

public class UserTestUtils {

    public static User generateRandomUser() {
        return User.builder()
                .userId(UserId.generateUserId())
                .username(RandomString.make(15))
                .email(RandomString.make(15) + "@example.com")
                .password(RandomString.make(15))
                .roles(List.of("USER"))
                .build();
    }
}
