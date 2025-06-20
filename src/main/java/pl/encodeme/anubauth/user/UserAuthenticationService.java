package pl.encodeme.anubauth.user;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.encodeme.anubauth.jwt.AccessToken;
import pl.encodeme.anubauth.jwt.RefreshToken;
import pl.encodeme.anubauth.jwt.UserTokenGenerator;
import pl.encodeme.anubauth.jwt.UserTokenParser;

@Service
@RequiredArgsConstructor
class UserAuthenticationService {

    private final UserTokenGenerator userAccessTokenGenerator;
    private final UserTokenGenerator userRefreshTokenGenerator;
    private final UserTokenParser userTokenParser;
    private final AuthenticationManager authenticationManager;
    private final UserAuthRepository userAuthRepository;

    public Pair<AccessToken, RefreshToken> generateUserToken(String email, String password) {
        var user = userAuthRepository.findByEmail(email);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        return Pair.of(
                new AccessToken(userAccessTokenGenerator.generateToken(user)),
                new RefreshToken(userRefreshTokenGenerator.generateToken(user))
        );
    }

    public AccessToken refreshAccessToken(String refreshToken) {
        var parsedToken = userTokenParser.parseToken(refreshToken);
        var user = userAuthRepository.findByEmail(parsedToken.getSubject());

        return new AccessToken(userAccessTokenGenerator.generateToken(user));
    }
}
