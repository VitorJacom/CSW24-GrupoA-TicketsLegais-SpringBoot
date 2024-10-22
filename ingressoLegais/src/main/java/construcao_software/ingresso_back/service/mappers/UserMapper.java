package construcao_software.ingresso_back.service.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import construcao_software.ingresso_back.service.dtos.UserDTO;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper() {
        this.modelMapper = new ModelMapper();
    }
    
    // Convert Model to Entity
    public UserEntity toEntity(UserModel model) {
        return modelMapper.map(model, UserEntity.class);
    }

    // Convert DTO to Entity
    public UserEntity toEntity(UserDTO dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    // Convert Entity to Model
    public UserModel toModel(UserEntity entity) {
        return modelMapper.map(entity, UserModel.class);
    }

    // Convert Entity to DTO
    public UserDTO toDTO(UserEntity entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

}
