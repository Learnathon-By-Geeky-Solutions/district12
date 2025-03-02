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

-- Populate alerts table with sub_tables

-- Insert first crop alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (1, 'CROP', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO crop_alerts (alert_id, user_crop_id, crop_alert_type)
VALUES (@last_alert_id, 1, 'DISEASE');

-- Insert second crop alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (2, 'CROP', 'MEDIUM', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO crop_alerts (alert_id, user_crop_id, crop_alert_type)
VALUES (@last_alert_id, 2, 'HARVEST_READY');

-- Insert third crop alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (3, 'CROP', 'LOW', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO crop_alerts (alert_id, user_crop_id, crop_alert_type)
VALUES (@last_alert_id, 3, 'WATERING_NEEDED');

-- Insert fourth crop alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (4, 'CROP', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO crop_alerts (alert_id, user_crop_id, crop_alert_type)
VALUES (@last_alert_id, 4, 'FERTILIZER_NEEDED');

-- Insert fifth crop alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (5, 'CROP', 'MEDIUM', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO crop_alerts (alert_id, user_crop_id, crop_alert_type)
VALUES (@last_alert_id, 5, 'PEST_INFESTATION');



-- Insert first task alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (1, 'TASK', 'LOW', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO task_alerts (alert_id, task_type, due_time)
VALUES (@last_alert_id, 'PLANTING', NOW() + INTERVAL 1 DAY);

-- Insert second task alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (2, 'TASK', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO task_alerts (alert_id, task_type, due_time)
VALUES (@last_alert_id, 'IRRIGATION', NOW() + INTERVAL 2 DAY);

-- Insert third task alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (3, 'TASK', 'MEDIUM', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO task_alerts (alert_id, task_type, due_time)
VALUES (@last_alert_id, 'FERTILIZATION', NOW() + INTERVAL 3 DAY);

-- Insert fourth task alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (4, 'TASK', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO task_alerts (alert_id, task_type, due_time)
VALUES (@last_alert_id, 'HARVESTING', NOW() + INTERVAL 4 DAY);

-- Insert fifth task alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (5, 'TASK', 'LOW', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO task_alerts (alert_id, task_type, due_time)
VALUES (@last_alert_id, 'SOIL_TESTING', NOW() + INTERVAL 5 DAY);



-- Insert first weather alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (1, 'WEATHER', 'MEDIUM', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO weather_alerts (alert_id, weather_type, forecasted_at)
VALUES (@last_alert_id, 'STORM', NOW() + INTERVAL 1 DAY);

-- Insert second weather alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (2, 'WEATHER', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO weather_alerts (alert_id, weather_type, forecasted_at)
VALUES (@last_alert_id, 'HEAT_WAVE', NOW() + INTERVAL 2 DAY);

-- Insert third weather alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (3, 'WEATHER', 'LOW', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO weather_alerts (alert_id, weather_type, forecasted_at)
VALUES (@last_alert_id, 'COLD_SNAP', NOW() + INTERVAL 3 DAY);

-- Insert fourth weather alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (4, 'WEATHER', 'HIGH', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO weather_alerts (alert_id, weather_type, forecasted_at)
VALUES (@last_alert_id, 'HEAVY_RAINFALL', NOW() + INTERVAL 4 DAY);

-- Insert fifth weather alert
INSERT INTO alerts (user_id, alert_type, priority, created_at, read_at)
VALUES (5, 'WEATHER', 'MEDIUM', NOW(), NULL);
SET @last_alert_id = LAST_INSERT_ID();
INSERT INTO weather_alerts (alert_id, weather_type, forecasted_at)
VALUES (@last_alert_id, 'DROUGHT', NOW() + INTERVAL 5 DAY);