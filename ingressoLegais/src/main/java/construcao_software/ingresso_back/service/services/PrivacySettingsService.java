package construcao_software.ingresso_back.service.services;

import org.springframework.beans.factory.annotation.Autowired;

import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.PrivacySettingsJpaRepository;
import construcao_software.ingresso_back.service.mappers.PrivacySettingsMapper;

public class PrivacySettingsService {
    
    private final PrivacySettingsJpaRepository repository;
    private final PrivacySettingsMapper mapper;

    @Autowired
    public PrivacySettingsService(PrivacySettingsJpaRepository repository, PrivacySettingsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Read (By ID)
    public PrivacySettingsEntity getSettingsByUser(Long userId) {
        return mapper.toEntity(repository.findByUserId(userId));
    }
}
