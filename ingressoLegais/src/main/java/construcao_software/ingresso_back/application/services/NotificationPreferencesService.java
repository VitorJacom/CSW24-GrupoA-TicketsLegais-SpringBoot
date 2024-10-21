package construcao_software.ingresso_back.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.infrastructure.persistence.repository.NotificationPreferencesJpaRepository;
import construcao_software.ingresso_back.application.mappers.NotificationPreferencesMapper;

@Service
public class NotificationPreferencesService {
    
    private final NotificationPreferencesJpaRepository repository;
    private final NotificationPreferencesMapper mapper;

    @Autowired
    public NotificationPreferencesService(NotificationPreferencesJpaRepository repository, NotificationPreferencesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
