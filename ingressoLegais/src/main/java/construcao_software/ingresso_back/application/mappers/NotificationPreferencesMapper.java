package construcao_software.ingresso_back.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.NotificationPreferencesEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.NotificationPreferencesModel;
import construcao_software.ingresso_back.application.dtos.NotificationPreferencesDTO;

@Component
public class NotificationPreferencesMapper {
    
    private final ModelMapper modelMapper;

    public NotificationPreferencesMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Converter Model para Entity
    public NotificationPreferencesEntity toEntity(NotificationPreferencesModel model) {
        return modelMapper.map(model, NotificationPreferencesEntity.class);
    }

    // Converter DTO para Entity
    public NotificationPreferencesEntity toEntity(NotificationPreferencesDTO dto) {
        return modelMapper.map(dto, NotificationPreferencesEntity.class);
    }

    // Converter Entity para Model
    public NotificationPreferencesModel toEntity(NotificationPreferencesEntity entity) {
        return modelMapper.map(entity, NotificationPreferencesModel.class);
    }

    // Converter Entity para DTO
    public NotificationPreferencesDTO toDTO(NotificationPreferencesEntity entity) {
        return modelMapper.map(entity, NotificationPreferencesDTO.class);
    }
}
