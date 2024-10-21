package construcao_software.ingresso_back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;

@Repository
public interface PrivacySettingsJpaRepository extends JpaRepository<PrivacySettingsModel, Long> {
    
    @Query("SELECT p FROM PrivacySettingsModel p WHERE p.userId = ?1")
    PrivacySettingsModel findByUserId(Long userId);
}
