package construcao_software.ingresso_back.service.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.service.dtos.TicketDTO;

@Component
public class TicketMapper {
    
    private final ModelMapper modelMapper;

    @Autowired
    public TicketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Convert Model to Entity
    public TicketEntity toEntity(TicketModel model) {
        return modelMapper.map(model, TicketEntity.class);
    }
    
    // Convert DTO to Entity
    public TicketEntity toEntity(TicketDTO dto) {
        return modelMapper.map(dto, TicketEntity.class);
    }

    // Convert Entity to Model
    public TicketModel toModel(TicketEntity entity) {
        return modelMapper.map(entity, TicketModel.class);
    }

    // Convert Entity to DTO
    public TicketDTO toDTO(TicketEntity entity) {
        return modelMapper.map(entity, TicketDTO.class);
    }
}
