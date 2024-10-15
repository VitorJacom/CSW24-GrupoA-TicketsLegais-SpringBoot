package construcao_software.ingresso_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import construcao_software.ingresso_back.service.mappers.NotificationPreferencesMapper;
import construcao_software.ingresso_back.service.services.NotificationPreferencesService;

@RestController
@RequestMapping("/api/notification-preferences")
public class NotificationPreferencesController {
    
    private final NotificationPreferencesService notificationPreferencesService;
    private final NotificationPreferencesMapper notificationPreferencesMapper;

    @Autowired
    public NotificationPreferencesController(NotificationPreferencesService notificationPreferencesService, NotificationPreferencesMapper notificationPreferencesMapper) {
        this.notificationPreferencesService = notificationPreferencesService;
        this.notificationPreferencesMapper = notificationPreferencesMapper;
    }
}
