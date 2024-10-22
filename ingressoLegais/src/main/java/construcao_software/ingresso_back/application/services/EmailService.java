package construcao_software.ingresso_back.application.services;

import org.springframework.stereotype.Service;

import construcao_software.ingresso_back.domain.iRepositories.IEmailService;
import construcao_software.ingresso_back.infrastructure.persistence.hybernate.models.TransactionModel;

@Service
public class EmailService implements IEmailService {

    @Override
    public void sendPurchaseConfirmation(String recipientEmail, TransactionModel transaction) {
        // Mock: Apenas simula o envio de um e-mail
        System.out.println("Mock: Enviando e-mail de confirmação para " + recipientEmail);
        System.out.println("Mock: Detalhes da transação - ID: " + transaction.getTransactionId());
    }
}