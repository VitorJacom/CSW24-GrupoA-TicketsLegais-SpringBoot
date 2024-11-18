package construcao_software.ingresso_back;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.UserModel;
import construcao_software.ingresso_back.adapter.persistence.repository.UserJpaRepository;
import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.mappers.UserMapper;
import construcao_software.ingresso_back.application.services.UserService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class IngressoBackApplicationTests {

    @Mock
    private UserJpaRepository userJpaRepository;

    @Mock
    private UserMapper userMapper; // Mock do UserMapper

    @InjectMocks
    private UserService userService;

    @Test
    void contextLoads() {
        // Mock do comportamento do userMapper
        when(userMapper.toDTO(any(UserModel.class))).thenReturn(new UserDTO());

        // Simulação de comportamento do método findById no mock
        when(userJpaRepository.findById(1L)).thenReturn(Optional.of(new UserModel()));

        // Chamada real do método userService, que usa o repositório mockado
        Optional<UserDTO> result = userService.getUserByID(1L);

        // Verificação de que o resultado não é vazio, conforme esperado
        assertTrue(result.isPresent());

        // Verificação do uso do método findById no mock
        verify(userJpaRepository).findById(1L);
    }
}

