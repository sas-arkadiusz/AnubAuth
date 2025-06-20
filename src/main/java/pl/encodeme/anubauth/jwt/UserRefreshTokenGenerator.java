package pl.encodeme.anubauth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.encodeme.anubauth.model.User;

import java.time.Instant;

@Service
class UserRefreshTokenGenerator implements UserTokenGenerator {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.issuer}")
    private String jwtIssuer;

    @Value("${jwt.refresh-token-expiration-in-seconds}")
    private long refreshTokenExpirationInSeconds;

    @Override
    public String generateToken(User user) {
        var algorithm = Algorithm.HMAC256(jwtSecret);

        return JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(refreshTokenExpirationInSeconds))
                .withSubject(user.email())
                .withIssuer(jwtIssuer)
                .sign(algorithm);
    }
}
