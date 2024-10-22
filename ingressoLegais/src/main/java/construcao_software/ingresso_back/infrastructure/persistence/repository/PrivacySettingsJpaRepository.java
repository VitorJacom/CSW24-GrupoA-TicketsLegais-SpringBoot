package construcao_software.ingresso_back.infrastructure.persistence.repository;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivacySettingsJpaRepository extends JpaRepository<PrivacySettingsModel, Long> {

    //find by userid
    Optional<PrivacySettingsModel> findByUser_UserId(Long userId);
}
