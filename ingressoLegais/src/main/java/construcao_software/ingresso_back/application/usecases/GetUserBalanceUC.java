package construcao_software.ingresso_back.application.usecases;

import construcao_software.ingresso_back.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserBalanceUC {

    private final UserService userService;

        public Double run(Long sellerId) {
            return userService.getBalance(sellerId);
    }
}
