package construcao_software.ingresso_back.controller;

import construcao_software.ingresso_back.domain.entities.SampleDomain;
import construcao_software.ingresso_back.service.SampleMapper;
import construcao_software.ingresso_back.service.SampleService;
import construcao_software.ingresso_back.service.dto.SampleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/samples")
public class SampleController {

    @Autowired
    private SampleService service;

    @Autowired
    private SampleMapper mapper;

    // Create
    @PostMapping
    public ResponseEntity<SampleDTO> createSample(@RequestBody SampleDTO dto) {
        SampleDomain domain = mapper.toDomain(dto);
        SampleDomain created = service.createSample(domain);
        return ResponseEntity.ok(mapper.toDTO(created));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<SampleDTO>> getAllSamples() {
        List<SampleDTO> samples = service.getAllSamples().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(samples);
    }

    // Read By ID
    @GetMapping("/{id}")
    public ResponseEntity<SampleDTO> getSampleById(@PathVariable Long id) {
        SampleDomain sample = service.getSampleById(id);
        if (sample != null) {
            return ResponseEntity.ok(mapper.toDTO(sample));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<SampleDTO> updateSample(@PathVariable Long id, @RequestBody SampleDTO dto) {
        SampleDomain domain = mapper.toDomain(dto);
        SampleDomain updated = service.updateSample(id, domain);
        if (updated != null) {
            return ResponseEntity.ok(mapper.toDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSample(@PathVariable Long id) {
        boolean deleted = service.deleteSample(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}