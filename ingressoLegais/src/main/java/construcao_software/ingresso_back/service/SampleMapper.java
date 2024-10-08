package construcao_software.ingresso_back.service;

import construcao_software.ingresso_back.service.dto.SampleDTO;
import construcao_software.ingresso_back.domain.entities.SampleDomain;
import construcao_software.ingresso_back.infrastructure.persistence.entities.SampleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SampleMapper {

    private final ModelMapper modelMapper;

    public SampleMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Converter Entity para Domain
    public SampleDomain toDomain(SampleEntity entity) {
        return modelMapper.map(entity, SampleDomain.class);
    }

    // Converter Domain para Entity
    public SampleEntity toEntity(SampleDomain domain) {
        return modelMapper.map(domain, SampleEntity.class);
    }

    // Converter Domain para DTO
    public SampleDTO toDTO(SampleDomain domain) {
        return modelMapper.map(domain, SampleDTO.class);
    }

    // Converter DTO para Domain
    public SampleDomain toDomain(SampleDTO dto) {
        return modelMapper.map(dto, SampleDomain.class);
    }
}