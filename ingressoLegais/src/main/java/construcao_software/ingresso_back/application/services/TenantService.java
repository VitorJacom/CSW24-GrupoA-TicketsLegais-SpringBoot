package construcao_software.ingresso_back.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.entities.TenantEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.TenantJpaRepository;
import construcao_software.ingresso_back.application.mappers.TenantMapper;

@Service
public class TenantService {
    
    private final TenantJpaRepository repository;
    private final TenantMapper mapper;

    @Autowired
    public TenantService(TenantJpaRepository repository, TenantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TenantEntity createTenant(TenantEntity tenant) {
        return mapper.toEntity(repository.save(mapper.toModel(tenant)));
    }
    
    public List<TenantEntity> getAllTenants() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public Optional<TenantEntity> getTenantByID(Long tenantId) {
        return repository.findById(tenantId).map(mapper::toEntity);
    }
}
