package construcao_software.ingresso_back.adapter.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.NotificationPreferencesModel;

@Repository
public interface NotificationPreferencesJpaRepository extends JpaRepository<NotificationPreferencesModel, Long> {
    
    NotificationPreferencesModel findByUser_UserId(Long userId);
}
