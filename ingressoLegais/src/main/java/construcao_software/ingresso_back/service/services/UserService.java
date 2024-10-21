package construcao_software.ingresso_back.service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.repository.UserJpaRepository;
import construcao_software.ingresso_back.service.mappers.UserMapper;

@Service
public class UserService {
    
    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserService(UserJpaRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Get all Users
    public List<UserEntity> getAll() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }
}
