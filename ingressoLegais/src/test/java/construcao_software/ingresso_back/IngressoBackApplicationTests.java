package construcao_software.ingresso_back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.services.UserService;
import construcao_software.ingresso_back.domain.entities.UserEntity;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.UserModel;
import construcao_software.ingresso_back.infrastructure.persistence.repository.UserJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
@ComponentScan(basePackages = "construcao_software.ingresso_back")
class IngressoBackApplicationTests {

    @MockBean
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserService userService;

	@Test
	void contextLoads() {
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

