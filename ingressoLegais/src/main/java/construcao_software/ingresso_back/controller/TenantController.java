package construcao_software.ingresso_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.service.dtos.TenantDTO;
import construcao_software.ingresso_back.service.mappers.TenantMapper;
import construcao_software.ingresso_back.service.services.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    
    private final TenantService service;
    private final TenantMapper mapper;

    @Autowired
    public TenantController(TenantService service, TenantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseEntity<TenantDTO> createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantEntity tenant = mapper.toEntity(tenantDTO);
        TenantDTO tenantCreated = mapper.toDTO(service.createTenant(tenant));
        return ResponseEntity.ok(tenantCreated);
    }
}
