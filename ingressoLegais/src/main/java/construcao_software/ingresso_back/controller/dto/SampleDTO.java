package construcao_software.ingresso_back.controller.dto;

import construcao_software.ingresso_back.domain.util.ConvertibleToDomainEntity;
import construcao_software.ingresso_back.persistence.SampleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO implements ConvertibleToDomainEntity<SampleEntity, SampleDTO>{
    
    private Long id;
    private String name;

    @Override
    public SampleDTO toDomainEntity(SampleEntity entity) {
        return new SampleDTO(entity.getId(), entity.getName());
    }
    @Override
    public SampleEntity fromDomainEntity() {
        return new SampleEntity(id, name);
    }
}
