package Zut_IPZ.Inwentaryzacja.password;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEncodingService {
    private final PasswordEncoder passwordEncoder;
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
