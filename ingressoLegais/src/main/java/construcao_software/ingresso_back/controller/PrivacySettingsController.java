package construcao_software.ingresso_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
import construcao_software.ingresso_back.service.dtos.PrivacySettingsDTO;
import construcao_software.ingresso_back.service.mappers.PrivacySettingsMapper;
import construcao_software.ingresso_back.service.services.PrivacySettingsService;

@RestController
@RequestMapping("/api/privacy-settings")
public class PrivacySettingsController {
    
    private final PrivacySettingsService service;
    private final PrivacySettingsMapper mapper;

    @Autowired
    public PrivacySettingsController(PrivacySettingsService service, PrivacySettingsMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

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
