SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS configuracoes_de_privacidade;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS evento;
DROP TABLE IF EXISTS notification_preferences;
DROP TABLE IF EXISTS preferencias_de_notificacao;
DROP TABLE IF EXISTS privacy_settings;
DROP TABLE IF EXISTS sample_entity;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS transacao;
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS usuario;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO tenant (name, contact_information, specific_configurations) VALUES 
('Tenant One', 'tenant1@example.com', 'Configuration 1'),
('Tenant Two', 'tenant2@example.com', 'Configuration 2'),
('Tenant Three', 'tenant3@example.com', 'Configuration 3'),
('Tenant Four', 'tenant4@example.com', 'Configuration 4'),
('Tenant Five', 'tenant5@example.com', 'Configuration 5');

INSERT INTO user (tenant_id, name, email, firebase_token, privacy_settings_id) VALUES 
(1, 'User One', 'user1@example.com', 'token1', NULL),
(1, 'User Two', 'user2@example.com', 'token2', NULL),
(2, 'User Three', 'user3@example.com', 'token3', NULL),
(2, 'User Four', 'user4@example.com', 'token4', NULL),
(3, 'User Five', 'user5@example.com', 'token5', NULL),
(3, 'User Six', 'user6@example.com', 'token6', NULL),
(4, 'User Seven', 'user7@example.com', 'token7', NULL),
(4, 'User Eight', 'user8@example.com', 'token8', NULL),
(5, 'User Nine', 'user9@example.com', 'token9', NULL),
(5, 'User Ten', 'user10@example.com', 'token10', NULL);


INSERT INTO event (tenant_id, event_name, type, location, date_time) VALUES 
(1, 'Concert One', 'Music', 'Location A', '2024-11-01 19:00:00'),
(1, 'Festival One', 'Festival', 'Location B', '2024-11-05 16:00:00'),
(2, 'Concert Two', 'Music', 'Location C', '2024-11-10 20:00:00'),
(2, 'Theatre Play One', 'Theatre', 'Location D', '2024-11-12 18:30:00'),
(3, 'Conference One', 'Conference', 'Location E', '2024-11-15 09:00:00'),
(3, 'Festival Two', 'Festival', 'Location F', '2024-11-17 17:00:00'),
(4, 'Concert Three', 'Music', 'Location G', '2024-11-20 21:00:00'),
(4, 'Theatre Play Two', 'Theatre', 'Location H', '2024-11-22 19:30:00'),
(5, 'Conference Two', 'Conference', 'Location I', '2024-11-25 10:00:00'),
(5, 'Concert Four', 'Music', 'Location J', '2024-11-28 20:00:00'),
(1, 'Workshop One', 'Workshop', 'Location K', '2024-12-01 14:00:00'),
(2, 'Seminar One', 'Seminar', 'Location L', '2024-12-03 15:00:00'),
(3, 'Festival Three', 'Festival', 'Location M', '2024-12-05 18:00:00'),
(4, 'Conference Three', 'Conference', 'Location N', '2024-12-07 09:30:00'),
(5, 'Workshop Two', 'Workshop', 'Location O', '2024-12-09 13:00:00');

INSERT INTO ticket (event_id, tenant_id, original_price, seller_id, unique_verification_code, status) VALUES 
(1, NULL, 50.00, 1, 'CODE1-AVAIL', 'AVAILABLE'),
(1, NULL, 60.00, 2, 'CODE2-RES', 'RESERVED'),
(2, NULL, 70.00, 3, 'CODE3-AVAIL', 'AVAILABLE'),
(2, 1, 80.00, 4, 'CODE4-SOLD', 'SOLD'),
(3, 1, 45.00, 5, 'CODE5-USED', 'USED'),
(3, NULL, 90.00, 1, 'CODE6-AVAIL', 'AVAILABLE'),
(4, NULL, 55.00, 2, 'CODE7-RES', 'RESERVED'),
(4, NULL, 65.00, 3, 'CODE8-AVAIL', 'AVAILABLE'),
(5, 2, 75.00, 4, 'CODE9-SOLD', 'SOLD'),
(5, 2, 85.00, 5, 'CODE10-USED', 'USED'),
(6, NULL, 40.00, 1, 'CODE11-AVAIL', 'AVAILABLE'),
(6, NULL, 60.00, 2, 'CODE12-RES', 'RESERVED'),
(7, NULL, 70.00, 3, 'CODE13-AVAIL', 'AVAILABLE'),
(7, 3, 80.00, 4, 'CODE14-SOLD', 'SOLD'),
(8, 3, 50.00, 5, 'CODE15-USED', 'USED'),
(8, NULL, 90.00, 1, 'CODE16-AVAIL', 'AVAILABLE'),
(9, NULL, 55.00, 2, 'CODE17-RES', 'RESERVED'),
(9, NULL, 65.00, 3, 'CODE18-AVAIL', 'AVAILABLE'),
(10, 4, 75.00, 4, 'CODE19-SOLD', 'SOLD'),
(10, 4, 85.00, 5, 'CODE20-USED', 'USED'),
(11, NULL, 45.00, 1, 'CODE21-AVAIL', 'AVAILABLE'),
(12, NULL, 55.00, 2, 'CODE22-RES', 'RESERVED'),
(13, NULL, 65.00, 3, 'CODE23-AVAIL', 'AVAILABLE'),
(14, 5, 75.00, 4, 'CODE24-SOLD', 'SOLD'),
(15, 5, 85.00, 5, 'CODE25-USED', 'USED');

INSERT INTO transaction (tenant_id, buyer_id, ticket_id, selling_price, transaction_date, transaction_status) VALUES 
(1, 4, 4, 80.00, '2024-10-21 12:00:00', 1), -- Ticket 4 (SOLD)
(1, 5, 5, 45.00, '2024-10-21 12:05:00', 1), -- Ticket 5 (USED)
(2, 4, 9, 75.00, '2024-10-21 12:10:00', 1), -- Ticket 9 (SOLD)
(2, 5, 10, 85.00, '2024-10-21 12:15:00', 1), -- Ticket 10 (USED)
(3, 4, 14, 80.00, '2024-10-21 12:20:00', 1), -- Ticket 14 (SOLD)
(3, 5, 15, 50.00, '2024-10-21 12:25:00', 1), -- Ticket 15 (USED)
(4, 4, 19, 75.00, '2024-10-21 12:30:00', 1), -- Ticket 19 (SOLD)
(4, 5, 20, 85.00, '2024-10-21 12:35:00', 1), -- Ticket 20 (USED)
(5, 4, 24, 75.00, '2024-10-21 12:40:00', 1), -- Ticket 24 (SOLD)
(5, 5, 25, 85.00, '2024-10-21 12:45:00', 1); -- Ticket 25 (USED)

INSERT INTO privacy_settings (user_id, allow_data_sharing, profile_visibility, transaction_history_visibility, allow_marketing_communications) VALUES
(1, true, 'PUBLIC', true, true),   -- Configurações de privacidade para o Usuário 1
(2, false, 'PRIVATE', false, false), -- Configurações de privacidade para o Usuário 2
(3, true, 'FRIENDS_ONLY', true, false), -- Configurações de privacidade para o Usuário 3
(4, true, 'PUBLIC', false, true),  -- Configurações de privacidade para o Usuário 4
(5, false, 'PRIVATE', true, false), -- Configurações de privacidade para o Usuário 5
(6, true, 'PUBLIC', false, true),  -- Configurações de privacidade para o Usuário 6
(7, true, 'FRIENDS_ONLY', true, true), -- Configurações de privacidade para o Usuário 7
(8, false, 'PRIVATE', false, false), -- Configurações de privacidade para o Usuário 8
(9, true, 'PUBLIC', true, true),   -- Configurações de privacidade para o Usuário 9
(10, false, 'PRIVATE', false, true); -- Configurações de privacidade para o Usuário 10

INSERT INTO notification_preferences (user_id, allow_email_notifications, allow_push_notifications) VALUES
(1, true, true),   -- Preferências de notificação para o Usuário 1
(2, false, true),  -- Preferências de notificação para o Usuário 2
(3, true, false),  -- Preferências de notificação para o Usuário 3
(4, true, true),   -- Preferências de notificação para o Usuário 4
(5, false, false), -- Preferências de notificação para o Usuário 5
(6, true, true),   -- Preferências de notificação para o Usuário 6
(7, false, true),  -- Preferências de notificação para o Usuário 7
(8, true, false),  -- Preferências de notificação para o Usuário 8
(9, true, true),   -- Preferências de notificação para o Usuário 9
(10, false, false);-- Preferências de notificação para o Usuário 10


UPDATE user
SET privacy_settings_id = CASE
    WHEN name = 'User One' THEN 1
    WHEN name = 'User Two' THEN 2
    WHEN name = 'User Three' THEN 3
    WHEN name = 'User Four' THEN 4
    WHEN name = 'User Five' THEN 5
    WHEN name = 'User Six' THEN 6
    WHEN name = 'User Seven' THEN 7
    WHEN name = 'User Eight' THEN 8
    WHEN name = 'User Nine' THEN 9
    WHEN name = 'User Ten' THEN 10
END
WHERE name IN ('User One', 'User Two', 'User Three', 'User Four', 'User Five', 'User Six', 'User Seven', 'User Eight', 'User Nine', 'User Ten');
