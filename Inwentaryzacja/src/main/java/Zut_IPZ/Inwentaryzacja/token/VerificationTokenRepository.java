package Zut_IPZ.Inwentaryzacja.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    @Override
    Optional<VerificationToken> findById(Long aLong);
    Optional<VerificationToken> findByToken(String Token);
}
