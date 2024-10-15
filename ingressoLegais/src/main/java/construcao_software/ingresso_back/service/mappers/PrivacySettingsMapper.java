package construcao_software.ingresso_back.service.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.PrivacySettingsEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.PrivacySettingsModel;
import construcao_software.ingresso_back.service.dtos.PrivacySettingsDTO;

@Component
public class PrivacySettingsMapper {
    
    private final ModelMapper modelMapper;

    public PrivacySettingsMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Convert Model to Entity
    public PrivacySettingsEntity toEntity(PrivacySettingsModel model) {
        return modelMapper.map(model, PrivacySettingsEntity.class);
    }

    // Convert DTO to Entity

    public PrivacySettingsEntity toEntity(PrivacySettingsDTO dto) {
        return modelMapper.map(dto, PrivacySettingsEntity.class);
    }

    // Convert Entity to Model
    public PrivacySettingsModel toEntity(PrivacySettingsEntity entity) {
        return modelMapper.map(entity, PrivacySettingsModel.class);
    }

    // Convert Entity to DTO
    public PrivacySettingsDTO toDTO(PrivacySettingsEntity entity) {
        return modelMapper.map(entity, PrivacySettingsDTO.class);
    }
}
