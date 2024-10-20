package construcao_software.ingresso_back.application.services;

import construcao_software.ingresso_back.domain.entities.SampleEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.SampleModel;
import construcao_software.ingresso_back.infrastructure.persistence.repository.SampleJpaRepository;
import construcao_software.ingresso_back.application.mappers.SampleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SampleService {

    private final SampleJpaRepository repository;
    private final SampleMapper mapper;

    @Autowired
    public SampleService(SampleJpaRepository repository, SampleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Create
    public SampleEntity createSample(SampleEntity domain) {
        SampleModel entity = mapper.toEntity(domain);
        entity = repository.save(entity);
        return mapper.toEntity(entity);
    }

    // Read (All)
    public List<SampleEntity> getAllSamples() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    // Read (By ID)
    public SampleEntity getSampleById(Long id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }

    // Update
    public SampleEntity updateSample(Long id, SampleEntity domain) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setName(domain.getName());
                    entity.setDescription(domain.getDescription());
                    SampleModel updated = repository.save(entity);
                    return mapper.toEntity(updated);
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
