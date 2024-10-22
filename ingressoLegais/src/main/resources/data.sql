INSERT IGNORE INTO tenant (name, contactInformation, specificConfigurations) VALUES 
('Tenant One', 'tenant1@example.com', 'Configuration 1'),
('Tenant Two', 'tenant2@example.com', 'Configuration 2'),
('Tenant Three', 'tenant3@example.com', 'Configuration 3'),
('Tenant Four', 'tenant4@example.com', 'Configuration 4'),
('Tenant Five', 'tenant5@example.com', 'Configuration 5');

INSERT IGNORE INTO user (tenant_id, name, email, firebaseToken, privacy_settings_id) VALUES 
(1, 'User One', 'user1@example.com', 'token1', 1),
(1, 'User Two', 'user2@example.com', 'token2', 2),
(2, 'User Three', 'user3@example.com', 'token3', 3),
(2, 'User Four', 'user4@example.com', 'token4', 4),
(3, 'User Five', 'user5@example.com', 'token5', 5),
(3, 'User Six', 'user6@example.com', 'token6', 6),
(4, 'User Seven', 'user7@example.com', 'token7', 7),
(4, 'User Eight', 'user8@example.com', 'token8', 8),
(5, 'User Nine', 'user9@example.com', 'token9', 9),
(5, 'User Ten', 'user10@example.com', 'token10', 10);

INSERT IGNORE INTO event (tenant_id, eventName, type, location, dateTime) VALUES 
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

INSERT IGNORE INTO ticket (event_id, tenant_id, originalPrice, seller_id, uniqueVerificationCode, status) VALUES 
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

INSERT IGNORE INTO transaction (tenant_id, buyer_id, ticket_id, sellingPrice, transactionDate, transactionStatus) VALUES 
(1, 4, 4, 80.00, '2024-10-21 12:00:00', 'COMPLETED'), -- Ticket 4 (SOLD)
(1, 5, 5, 45.00, '2024-10-21 12:05:00', 'COMPLETED'), -- Ticket 5 (USED)
(2, 4, 9, 75.00, '2024-10-21 12:10:00', 'COMPLETED'), -- Ticket 9 (SOLD)
(2, 5, 10, 85.00, '2024-10-21 12:15:00', 'COMPLETED'), -- Ticket 10 (USED)
(3, 4, 14, 80.00, '2024-10-21 12:20:00', 'COMPLETED'), -- Ticket 14 (SOLD)
(3, 5, 15, 50.00, '2024-10-21 12:25:00', 'COMPLETED'), -- Ticket 15 (USED)
(4, 4, 19, 75.00, '2024-10-21 12:30:00', 'COMPLETED'), -- Ticket 19 (SOLD)
(4, 5, 20, 85.00, '2024-10-21 12:35:00', 'COMPLETED'), -- Ticket 20 (USED)
(5, 4, 24, 75.00, '2024-10-21 12:40:00', 'COMPLETED'), -- Ticket 24 (SOLD)
(5, 5, 25, 85.00, '2024-10-21 12:45:00', 'COMPLETED'); -- Ticket 25 (USED)

INSERT IGNORE INTO privacy_settings (user_id, allowDataSharing, profileVisibility, transactionHistoryVisibility, allowMarketingCommunications) VALUES
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

INSERT IGNORE INTO notification_preferences (user_id, allowEmailNotifications, allowPushNotifications) VALUES
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
