package construcao_software.ingresso_back.adapter.lambda;

import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;
import construcao_software.ingresso_back.application.dtos.NotificationPreferencesRequestDTO;
import construcao_software.ingresso_back.application.services.NotificationPreferencesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.BiFunction;
import java.util.function.Function;

@Configuration
public class NotificationPreferencesFunctionConfig {

    private final NotificationPreferencesService notificationPreferencesService;

    public NotificationPreferencesFunctionConfig(NotificationPreferencesService notificationPreferencesService) {
        this.notificationPreferencesService = notificationPreferencesService;
    }

    // Function para buscar as preferências de notificação pelo userId
    @Bean
    public Function<Long, NotificationPreferencesDTO> getNotificationPreferences() {
        return notificationPreferencesService::getByUser;
    }

    // BiFunction para atualizar as preferências de notificação
    @Bean
    public BiFunction<Long, NotificationPreferencesRequestDTO, NotificationPreferencesDTO> updateNotificationPreferences() {
        return notificationPreferencesService::updatePreferences;
    }
}
