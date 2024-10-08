package construcao_software.ingresso_back.service;

import construcao_software.ingresso_back.domain.entities.SampleDomain;
import construcao_software.ingresso_back.infrastructure.persistence.entities.SampleEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.SampleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SampleService {

    @Autowired
    private SampleJpaRepository repository;

    @Autowired
    private SampleMapper mapper;

    // Create
    public SampleDomain createSample(SampleDomain domain) {
        SampleEntity entity = mapper.toEntity(domain);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    // Read (All)
    public List<SampleDomain> getAllSamples() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    // Read (By ID)
    public SampleDomain getSampleById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    // Update
    public SampleDomain updateSample(Long id, SampleDomain domain) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(domain.getName());
                    entity.setDescription(domain.getDescription());
                    SampleEntity updated = repository.save(entity);
                    return mapper.toDomain(updated);
                })
                .orElse(null);
    }

    // Delete
    public boolean deleteSample(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return true;
                })
                .orElse(false);
    }
}
