package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.application.mappers.PrivacySettingsMapper;
import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.PrivacySettingsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrivacySettingsService {
    
    private final PrivacySettingsJpaRepository repository;
    private final PrivacySettingsMapper mapper;

    public PrivacySettingsEntity getSettingsByUser(Long userId) {
        return repository.findByUser_UserId(userId)
                .map(mapper::toEntity)
                .orElse(null);
    }
}
