package pl.encodeme.anubauth.utils;

import net.bytebuddy.utility.RandomString;
import pl.encodeme.anubauth.model.User;
import pl.encodeme.anubauth.model.UserId;

public class UserTestUtils {

    public static User generateRandomUser() {
        return User.builder()
                .id(UserId.generateUserId())
                .username(RandomString.make(15))
                .email(RandomString.make(15) + "@example.com")
                .password(RandomString.make(15))
                .role("USER")
                .build();
    }
}
