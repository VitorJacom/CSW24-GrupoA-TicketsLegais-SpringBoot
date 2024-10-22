package construcao_software.ingresso_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;
import construcao_software.ingresso_back.application.mappers.NotificationPreferencesMapper;
import construcao_software.ingresso_back.application.services.NotificationPreferencesService;

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
    
    // GET: /api/notification-preferences/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<NotificationPreferencesDTO> getNotificationPreferences(@PathVariable Long userId) {
        NotificationPreferencesDTO dto = notificationPreferencesService.getByUser(userId);
        return ResponseEntity.ok(dto);
    }

    // PUT: /api/notification-preferences/{userId}
    @PutMapping("/{userId}")
    public ResponseEntity<NotificationPreferencesDTO> updateNotificationPreferences(
            @PathVariable Long userId, 
            @RequestBody NotificationPreferencesDTO dto) {
        NotificationPreferencesDTO updatedDto = notificationPreferencesService.updatePreferences(userId, dto);
        return ResponseEntity.ok(updatedDto);
    }
}
