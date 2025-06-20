package pl.encodeme.anubauth.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.encodeme.anubauth.utils.UserTestUtils.generateRandomUser;

@SpringBootTest
class UserTokenParserIntegrationTest {

    @Autowired
    private UserAccessTokenGenerator accessTokenGenerator;

    @Autowired
    private UserTokenParser tokenParser;

    @Test
    void shouldParseValidToken() {
        // Given
        var user = generateRandomUser();
        var token = accessTokenGenerator.generateToken(user);

        // When
        var decodedJWT = tokenParser.parseToken(token);

        // Then
        assertThat(decodedJWT).isNotNull();
        assertThat(decodedJWT.getSubject()).isEqualTo(user.email());
        assertThat(decodedJWT.getClaim(TokenClaims.USER_ID.name()).asString()).isEqualTo(user.userId().toString());
        assertThat(decodedJWT.getClaim(TokenClaims.EMAIL.name()).asString()).isEqualTo(user.email());
        assertThat(decodedJWT.getClaim(TokenClaims.ROLE.name()).asList(String.class)).isEqualTo(user.roles());
    }
}

