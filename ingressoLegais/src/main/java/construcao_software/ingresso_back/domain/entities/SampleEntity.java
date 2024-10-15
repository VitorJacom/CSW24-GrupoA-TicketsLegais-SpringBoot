package construcao_software.ingresso_back.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleEntity {
    private Long id;
    private String name;
    private String description;

     // Métodos de negócio podem ser adicionados aqui
}
