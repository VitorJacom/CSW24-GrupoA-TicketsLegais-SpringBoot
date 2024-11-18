package construcao_software.ingresso_back.adapter.controller;

import construcao_software.ingresso_back.application.dtos.NotificationPreferencesRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;
import construcao_software.ingresso_back.application.services.NotificationPreferencesService;

@RestController
@RequestMapping("/api/notification-preferences")
@RequiredArgsConstructor
public class NotificationPreferencesController {
    
    private final NotificationPreferencesService notificationPreferencesService;

    @GetMapping("/{userId}")
    public ResponseEntity<NotificationPreferencesDTO> getNotificationPreferences(@PathVariable Long userId) {
        NotificationPreferencesDTO dto = notificationPreferencesService.getByUser(userId);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<NotificationPreferencesDTO> updateNotificationPreferences(
            @PathVariable Long userId, 
            @RequestBody NotificationPreferencesRequestDTO dto) {
        NotificationPreferencesDTO updatedDto = notificationPreferencesService.updatePreferences(userId, dto);
        return ResponseEntity.ok(updatedDto);
    }
}
