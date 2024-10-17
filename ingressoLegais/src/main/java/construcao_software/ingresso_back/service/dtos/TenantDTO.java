package construcao_software.ingresso_back.service.dtos;

import lombok.Data;

@Data
public class TenantDTO {
    
    private Long id;
    private String name;
    private String contactInformation;
    private String specificConfigurations;    
}
