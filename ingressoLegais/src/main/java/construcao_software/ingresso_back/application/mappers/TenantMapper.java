package construcao_software.ingresso_back.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TenantModel;
import construcao_software.ingresso_back.application.dtos.TenantDTO;

@Component
public class TenantMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TenantMapper() {
        this.modelMapper = new ModelMapper();
    }

    public TenantEntity toEntity(TenantModel model) {
        return modelMapper.map(model, TenantEntity.class);
    }

    public TenantEntity toEntity(TenantDTO dto) {
        return modelMapper.map(dto, TenantEntity.class);
    }

    public TenantModel toModel(TenantEntity entity) {
        return modelMapper.map(entity, TenantModel.class);
    }

    public TenantModel toModel(TenantDTO dto) {
        return modelMapper.map(dto, TenantModel.class);
    }

    public TenantDTO toDTO(TenantEntity entity) {
        return modelMapper.map(entity, TenantDTO.class);
    }

    public TenantDTO toDTO(TenantModel model) {
        return modelMapper.map(model, TenantDTO.class);
    }

}
