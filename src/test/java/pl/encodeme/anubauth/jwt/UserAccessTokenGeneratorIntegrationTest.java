package pl.encodeme.anubauth.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.encodeme.anubauth.model.User;
import pl.encodeme.anubauth.model.UserId;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.encodeme.anubauth.utils.UserTestUtils.generateRandomUser;

@SpringBootTest
class UserAccessTokenGeneratorIntegrationTest {

    @Autowired
    private UserAccessTokenGenerator tokenGenerator;

    @Test
    void shouldGenerateValidToken() {
        // Given
        var user = generateRandomUser();

        // When
        var token = tokenGenerator.generateToken(user);

        // Then
        assertThat(token).isNotBlank();
    }
}
