package pl.encodeme.anubauth.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.encodeme.anubauth.utils.UserTestUtils.generateRandomUser;

@SpringBootTest
class UserRefreshTokenGeneratorIntegrationTest {

    @Autowired
    private UserRefreshTokenGenerator tokenGenerator;

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
