package construcao_software.ingresso_back.domain.iRepositories;

import construcao_software.ingresso_back.adapter.persistence.hybernate.models.TransactionModel;

public interface IEmailService {
    void sendPurchaseConfirmation(String recipientEmail, TransactionModel transaction);
}
