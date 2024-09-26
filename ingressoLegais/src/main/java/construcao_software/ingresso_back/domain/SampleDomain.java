package construcao_software.ingresso_back.domain;

import org.springframework.stereotype.Component;

import construcao_software.ingresso_back.controller.dto.SampleDTO;
import construcao_software.ingresso_back.persistence.SampleEntity;

@Component
public interface SampleService{
    public SampleDTO addContrato(SampleDTO dto);
}
