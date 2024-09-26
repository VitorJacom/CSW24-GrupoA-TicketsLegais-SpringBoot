package construcao_software.ingresso_back.persistence;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleEntity {
    
    @Column
    private Long id;

    @Column
    private String name;
}
