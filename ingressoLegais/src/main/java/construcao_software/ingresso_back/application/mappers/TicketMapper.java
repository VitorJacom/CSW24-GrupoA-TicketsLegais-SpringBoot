package construcao_software.ingresso_back.application.mappers;

import construcao_software.ingresso_back.application.dtos.CreateTicketDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TicketEntity;
import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TicketModel;
import construcao_software.ingresso_back.application.dtos.EventDTO;
import construcao_software.ingresso_back.application.dtos.TicketDTO;

@Component
public class TicketMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TicketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Convert Model to Entity
    public TicketEntity toEntity(EventDTO event) {
        return modelMapper.map(event, TicketEntity.class);
    }

    // Convert DTO to Entity
    public TicketEntity toEntity(TicketDTO dto) {
        return modelMapper.map(dto, TicketEntity.class);
    }

    // Convert Entity to Model
    public TicketModel toModelFromEntity(TicketEntity entity) {
        return modelMapper.map(entity, TicketModel.class);
    }
    
    public TicketModel toModelFromDTO(TicketDTO dto) {
        return modelMapper.map(dto, TicketModel.class);
    }
    
    

    // Convert Entity to DTO
    public TicketDTO toDTO(TicketEntity entity) {
        return modelMapper.map(entity, TicketDTO.class);
    }

    // Convert Model to DTO
    public TicketDTO toDTO(TicketModel model) {
        return modelMapper.map(model, TicketDTO.class);
    }
}
