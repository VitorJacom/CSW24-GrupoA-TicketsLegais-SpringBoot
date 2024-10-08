package construcao_software.ingresso_back.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SampleEntity {
    
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public SampleEntity(String name, String description){
        this.name = name;
        this.description = description;
    }
    
}
