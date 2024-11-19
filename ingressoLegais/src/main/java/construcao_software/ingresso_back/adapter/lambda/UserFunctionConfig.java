package construcao_software.ingresso_back.adapter.lambda;

import construcao_software.ingresso_back.application.dtos.UserDTO;
import construcao_software.ingresso_back.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class UserFunctionConfig {

    private final UserService service;

    public UserFunctionConfig(UserService service) {
        this.service = service;
    }

    // Supplier para obter todos os usuários
    @Bean
    public Supplier<List<UserDTO>> getAllUsers() {
        return service::getAll;
    }

    // Function para obter o saldo de um usuário por ID
    @Bean
    public Function<Long, Double> getBalance() {
        return service::getBalance;
    }
}
