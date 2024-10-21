package construcao_software.ingresso_back.application.mappers;

import construcao_software.ingresso_back.application.dtos.SampleDTO;
import construcao_software.ingresso_back.domain.entities.SampleEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.SampleModel;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SampleMapper {

    private final ModelMapper modelMapper;

    public SampleMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Converter Model para Entity
    public SampleEntity toEntity(SampleModel model) {
        return modelMapper.map(model, SampleEntity.class);
    }
    
    // Converter DTO para Entity
    public SampleEntity toEntity(SampleDTO dto) {
        return modelMapper.map(dto, SampleEntity.class);
    }

    // Converter Entity para Model
    public SampleModel toEntity(SampleEntity entity) {
        return modelMapper.map(entity, SampleModel.class);
    }

    // Converter Entity para DTO
    public SampleDTO toDTO(SampleEntity entity) {
        return modelMapper.map(entity, SampleDTO.class);
    }
}