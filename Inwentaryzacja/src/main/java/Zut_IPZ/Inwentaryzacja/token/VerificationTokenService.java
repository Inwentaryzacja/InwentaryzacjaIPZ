package Zut_IPZ.Inwentaryzacja.token;

import Zut_IPZ.Inwentaryzacja.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;

    public VerificationToken generateVerificationToken(User user) {
        return new VerificationToken(
                UUID.randomUUID().toString(),
                user,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                null


        );
    }

    public void saveVerificationToken(VerificationToken token) {
        verificationTokenRepository.save(token);

    }

    public boolean isTokenExpired(VerificationToken verificationToken) {
        return  LocalDateTime.now().isAfter(verificationToken.getExpiresAt());
    }

    public Optional<VerificationToken> getToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }
}
