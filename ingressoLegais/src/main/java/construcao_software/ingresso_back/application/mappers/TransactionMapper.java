package construcao_software.ingresso_back.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.TransactionEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TransactionModel;
import construcao_software.ingresso_back.application.dtos.TransactionDTO;

@Component
public class TransactionMapper {

    private final ModelMapper modelMapper;

    public TransactionMapper() {
        this.modelMapper = new ModelMapper();
    }

    // Convert Model to Entity
    public TransactionEntity toEntity(TransactionModel model) {
        return modelMapper.map(model, TransactionEntity.class);
    }

    // Convert DTO to Entity
    public TransactionEntity toEntity(TransactionDTO dto) {
        return modelMapper.map(dto, TransactionEntity.class);
    }

    // Convert Entity to Model
    public TransactionModel toModel(TransactionEntity entity) {
        return modelMapper.map(entity, TransactionModel.class);
    }

    // Convert Entity to DTO
    public TransactionDTO toDTO(TransactionEntity entity) {
        return modelMapper.map(entity, TransactionDTO.class);
    }

    // Convert Entity to DTO
    public TransactionDTO toDTO(TransactionModel model) {
        return modelMapper.map(model, TransactionDTO.class);
    }
}
