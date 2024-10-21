package construcao_software.ingresso_back.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import construcao_software.ingresso_back.domain.models.NotificationPreferences;
import construcao_software.ingresso_back.service.dtos.NotificationPreferencesDTO;
import construcao_software.ingresso_back.infrastructure.persistence.repository.NotificationPreferencesJpaRepository;
import construcao_software.ingresso_back.application.mappers.NotificationPreferencesMapper;

@Service
public class NotificationPreferencesService {
    
    private final NotificationPreferencesJpaRepository repository;
    private final NotificationPreferencesMapper mapper;

    @Autowired
    public NotificationPreferencesService(NotificationPreferencesJpaRepository repository, NotificationPreferencesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // GET by User
    public NotificationPreferencesDTO getByUser(Long userId) {
        NotificationPreferences preferences = repository.findByUserId(userId);
        return mapper.toDto(preferences);
    }

    // PUT
    public NotificationPreferencesDTO updatePreferences(Long userId, NotificationPreferencesDTO dto) {
        NotificationPreferences preferences = repository.findByUserId(userId);
        if (preferences != null) {
            preferences.setEmailNotifications(dto.getEmailNotifications());
            repository.save(preferences);
        } else {
            preferences = mapper.toEntity(dto);
            preferences.setUserId(userId);
            repository.save(preferences);
        }
        return mapper.toDto(preferences);
    }
}
