package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.application.dtos.PrivacySettingsDTO;
import construcao_software.ingresso_back.application.mappers.PrivacySettingsMapper;
import construcao_software.ingresso_back.application.services.PrivacySettingsService;
import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/privacy-settings")
@RequiredArgsConstructor
public class PrivacySettingsController {
    
    private final PrivacySettingsService service;
    private final PrivacySettingsMapper mapper;

    // Read (By User ID)
    @GetMapping("/{userId}")
    public ResponseEntity<PrivacySettingsDTO> getSettingsByUser(@PathVariable Long userId) {
        PrivacySettingsEntity settings = service.getSettingsByUser(userId);
        if (settings != null) {
            return ResponseEntity.ok(mapper.toDTO(settings));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
