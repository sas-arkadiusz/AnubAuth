package pl.encodeme.anubauth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserTokenParser {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.issuer}")
    private String jwtIssuer;

    public DecodedJWT parseToken(String token) {
        var algorithm = Algorithm.HMAC256(jwtSecret);
        var verifier = JWT.require(algorithm)
                .withIssuer(jwtIssuer)
                .build();
        return verifier.verify(token);
    }
}
