-- Populate users table
INSERT INTO users (email, full_name, password, role, phone_number)
VALUES
    ('alice@example.com', 'Alice Johnson', '$2a$10$Ag/EVWeldbSzlxzMHWPdKezgYSL41TWXlcz7iNCiH5F9VCP/hRIcG', 'USER', '1111111111'),
    ('bob@example.com', 'Bob Williams', '$2a$10$Ag/EVWeldbSzlxzMHWPdKezgYSL41TWXlcz7iNCiH5F9VCP/hRIcG', 'USER', '2222222222'),
    ('charlie@example.com', 'Charlie Brown', '$2a$10$Ag/EVWeldbSzlxzMHWPdKezgYSL41TWXlcz7iNCiH5F9VCP/hRIcG', 'USER', '3333333333'),
    ('david@example.com', 'David Smith', '$2a$10$Ag/EVWeldbSzlxzMHWPdKezgYSL41TWXlcz7iNCiH5F9VCP/hRIcG', 'USER', '4444444444'),
    ('emma@example.com', 'Emma Watson', '$2a$10$Ag/EVWeldbSzlxzMHWPdKezgYSL41TWXlcz7iNCiH5F9VCP/hRIcG', 'ADMIN', '5555555555');

-- Populate crops table
INSERT INTO crops (name, description)
VALUES
    ('Wheat', 'A cereal grain used for bread and pasta'),
    ('Rice', 'A staple food for many countries'),
    ('Corn', 'Used for food and animal feed'),
    ('Barley', 'Used in beer production and animal feed'),
    ('Soybeans', 'A protein-rich legume'),
    ('Potatoes', 'A root vegetable used in many cuisines'),
    ('Tomatoes', 'A versatile fruit used in cooking'),
    ('Carrots', 'A root vegetable rich in vitamins'),
    ('Lettuce', 'A leafy vegetable used in salads'),
    ('Peanuts', 'A popular legume and snack'),
    ('Sugarcane', 'Used to produce sugar'),
    ('Apples', 'A popular fruit rich in fiber'),
    ('Oranges', 'A citrus fruit rich in vitamin C'),
    ('Grapes', 'Used for wine and fresh consumption'),
    ('Strawberries', 'A sweet fruit used in desserts');

-- Populate user_crops table
INSERT INTO user_crops (user_id, crop_id, selected_at)
VALUES
    (1, 1, NOW()), -- Alice - Wheat
    (1, 2, NOW()), -- Alice - Rice
    (2, 3, NOW()), -- Bob - Corn
    (2, 4, NOW()), -- Bob - Barley
    (3, 5, NOW()), -- Charlie - Soybeans
    (3, 6, NOW()), -- Charlie - Potatoes
    (4, 7, NOW()), -- David - Tomatoes
    (4, 8, NOW()), -- David - Carrots
    (5, 9, NOW()), -- Emma - Lettuce
    (5, 10, NOW()), -- Emma - Peanuts
    (1, 11, NOW()), -- Alice - Sugarcane
    (2, 12, NOW()), -- Bob - Apples
    (3, 13, NOW()), -- Charlie - Oranges
    (4, 14, NOW()), -- David - Grapes
    (5, 15, NOW()); -- Emma - Strawberries