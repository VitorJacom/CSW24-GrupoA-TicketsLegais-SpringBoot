package construcao_software.ingresso_back.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.NotificationPreferencesModel;
import construcao_software.ingresso_back.infrastructure.persistence.repository.NotificationPreferencesJpaRepository;
import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;
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
        NotificationPreferencesModel preferences = repository.findByUser_UserId(userId);
        return mapper.toDTO(preferences);
    }

    // PUT
    public NotificationPreferencesDTO updatePreferences(Long userId, NotificationPreferencesDTO dto) {
        
        NotificationPreferencesModel preferences = repository.findByUser_UserId(userId);

        if (preferences != null) {
            preferences.setAllowEmailNotifications(dto.isAllowEmailNotifications());
            repository.save(preferences);
        } else {
            preferences = mapper.toModel(dto);
            preferences.setUser(mapper.toModel(dto).getUser());
            repository.save(preferences);
        }
        return mapper.toDTO(preferences);
    }
}
