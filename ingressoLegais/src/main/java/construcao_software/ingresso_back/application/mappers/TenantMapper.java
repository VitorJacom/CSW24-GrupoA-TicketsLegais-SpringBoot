package construcao_software.ingresso_back.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.application.dtos.TenantDTO;

@Component
public class TenantMapper {
    
    private final ModelMapper modelMapper;

    @Autowired
    public TenantMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Convert Model to Entity
    public TenantEntity toEntity(TenantModel model) {
        return modelMapper.map(model, TenantEntity.class);
    }

    // Convert DTO to Entity
    public TenantEntity toEntity(TenantDTO dto) {
        return modelMapper.map(dto, TenantEntity.class);
    }

    // Convert Entity to Model
    public TenantModel toModel(TenantEntity entity) {
        return modelMapper.map(entity, TenantModel.class);
    }

    // Convert Entity to DTO
    public TenantDTO toDTO(TenantEntity entity) {
        return modelMapper.map(entity, TenantDTO.class);
    }

}
