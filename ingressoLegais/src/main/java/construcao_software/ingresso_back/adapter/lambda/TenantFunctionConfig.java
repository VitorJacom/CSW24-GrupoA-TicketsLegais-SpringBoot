package construcao_software.ingresso_back.adapter.lambda;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.application.dtos.TenantDTO;
import construcao_software.ingresso_back.application.mappers.TenantMapper;
import construcao_software.ingresso_back.application.services.TenantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class TenantFunctionConfig {

    private final TenantService service;
    private final TenantMapper mapper;

    public TenantFunctionConfig(TenantService service, TenantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // Function para criar um novo Tenant
    @Bean
    public Function<TenantDTO, TenantDTO> createTenant() {
        return tenantDTO -> {
            TenantEntity tenantEntity = mapper.toEntity(tenantDTO);
            TenantEntity createdEntity = service.createTenant(tenantEntity);
            return mapper.toDTO(createdEntity);
        };
    }
}
