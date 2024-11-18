package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.UserModel;
import construcao_software.ingresso_back.adapter.persistence.repository.UserJpaRepository;
import construcao_software.ingresso_back.application.dtos.NotificationPreferencesRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.NotificationPreferencesModel;
import construcao_software.ingresso_back.adapter.persistence.repository.NotificationPreferencesJpaRepository;
import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;
import construcao_software.ingresso_back.application.mappers.NotificationPreferencesMapper;

@Service
@RequiredArgsConstructor
public class NotificationPreferencesService {

    private final UserJpaRepository userRepository;
    private final NotificationPreferencesJpaRepository repository;
    private final NotificationPreferencesMapper mapper;

    public NotificationPreferencesDTO getByUser(Long userId) {
        NotificationPreferencesModel preferences = repository.findByUser_UserId(userId);
        return mapper.toDTO(preferences);
    }

    public NotificationPreferencesDTO updatePreferences(Long userId, NotificationPreferencesRequestDTO dto) {

        NotificationPreferencesModel preferences = repository.findByUser_UserId(userId);

        if (preferences != null) {
            if (dto.allowPushNotifications() != null)
                preferences.setAllowPushNotifications(dto.allowPushNotifications());
            if (dto.allowEmailNotifications() != null)
                preferences.setAllowEmailNotifications(dto.allowEmailNotifications());
        } else {
            UserModel user = userRepository.findById(userId).orElseThrow();
            preferences = new NotificationPreferencesModel();
            preferences.setUser(user);
            preferences.setAllowPushNotifications(dto.allowPushNotifications());
            preferences.setAllowEmailNotifications(dto.allowEmailNotifications());
        }
        repository.save(preferences);
        return mapper.toDTO(preferences);
    }
}
