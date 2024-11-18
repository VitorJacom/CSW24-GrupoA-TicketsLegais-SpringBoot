package construcao_software.ingresso_back.application.dtos;

public record NotificationPreferencesRequestDTO(
        Boolean allowEmailNotifications,
        Boolean allowPushNotifications
) {
}
