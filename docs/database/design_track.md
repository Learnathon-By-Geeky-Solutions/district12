# Project Features Database Schema

## 1. Requirements Analysis

### Key Functionalities

#### User Management
- **Guest**: Limited access, can browse general crop information.
- **Registered User**: Can select and track crops, log daily activities, and communicate with officers.
- **Officer**: Engages in chat sessions with users, provides insights, and generates reports.
- **Admin**: Manages system users and oversees overall operations.

#### Crop Selection & Monitoring
- Users can choose multiple crops to monitor.
- Daily logs enable users to document observations, environmental conditions, and farming activities.

#### Communication via Chat System
- Registered users can send and receive messages from officers for farming guidance.
- Messages support text and file attachments.

#### Data Logging & Visualization
- Users submit daily logs in structured JSON format.
- Officers generate visual insights using filters (e.g., region, crop type) for agricultural trends.

#### Alerts & Notifications
- The system sends automatic alerts regarding crop diseases, task reminders, and scheduled activities.

## 2. Relational Schema

### Users Table
| Field        | Type         | Description                    |
|-------------|-------------|--------------------------------|
| id          | UUID (PK)    | Unique identifier for the user |
| name        | VARCHAR(255) | User’s full name              |
| email       | VARCHAR(255) | Unique user email             |
| password    | TEXT         | Hashed password               |
| user_type   | ENUM        | `guest`, `registered_user`, `officer`, `admin` |
| created_at  | TIMESTAMP    | Account creation timestamp    |
| updated_at  | TIMESTAMP    | Last profile update timestamp |

### Officers' Table
| Field        | Type         | Description                    |
|-------------|-------------|--------------------------------|
| id          | UUID (PK)    | Unique identifier for the officer |
| user_id     | UUID (FK)    | References `users.id`         |
| additional_attr       | VARCHAR(255) | Additoinal attribute for user |
| password    | TEXT         | Hashed password               |

### Crops Table
| Field        | Type         | Description           |
|-------------|-------------|----------------------|
| id          | UUID (PK)    | Unique crop identifier |
| name        | VARCHAR(255) | Crop name            |
| description | TEXT         | Crop details         |

### User_Crops Table
| Field        | Type      | Description                    |
|-------------|----------|--------------------------------|
| id          | UUID (PK) | Unique identifier             |
| user_id     | UUID (FK) | References `users.id`        |
| crop_id     | UUID (FK) | References `crops.id`        |
| selected_at | TIMESTAMP | Timestamp when selected      |

### Daily_Log Table
| Field       | Type      | Description                                |
|------------|----------|--------------------------------------------|
| id         | UUID (PK) | Unique log identifier                     |
| user_id    | UUID (FK) | References `users.id`                     |
| crop_id    | UUID (FK) | References `crops.id`                     |
| log_data   | JSON      | Structured responses from users          |
| log_date   | DATE      | Date of log entry                         |
| created_at | TIMESTAMP | Timestamp of entry creation              |

### Chat Table
| Field       | Type      | Description                              |
|------------|----------|------------------------------------------|
| id         | UUID (PK) | Unique chat identifier                   |
| sender_id  | UUID (FK) | References `users.id` (sender)          |
| receiver_id| UUID (FK) | References `users.id` (recipient)       |
| message    | TEXT      | Chat message content                     |
| sent_at    | TIMESTAMP | Time message was sent                   |

### Chat Attachment Table
| Field      | Type      | Description                              |
|-----------|----------|------------------------------------------|
| id        | UUID (PK) | Unique chat identifier                   |
| chat_id   | UUID (FK) | References `chat.id`                     |
| attachment| TEXT (URL)| File path to uploaded attachment (if any) |
| type      | VARCHAR(20) | Type of attachment                      |

### Chat_Session Table
| Field      | Type      | Description                           |
|-----------|----------|-------------------------------------|
| id        | UUID (PK) | Unique session identifier           |
| chat_id   | UUID (FK) | References `chat.id`                |
| user_id   | UUID (FK) | References `users.id` (user)        |
| officer_id| UUID (FK) | References `users.id` (officer)     |
| started_at| TIMESTAMP | Chat session start time             |

### Broad_Data_Visualization Table
| Field        | Type      | Description                           |
|-------------|----------|---------------------------------------|
| id          | UUID (PK) | Unique identifier                     |
| officer_id  | UUID (FK) | References `users.id` (officer)      |
| filter_area | VARCHAR(255) | Region filtered                     |
| filter_crop | UUID (FK) | References `crops.id` (filtered crop) |
| data_report | JSON      | Aggregated farming insights          |
| generated_at| TIMESTAMP | Data generation timestamp            |

### Alerts Table
| Field       | Type      | Description                           |
|------------|----------|-------------------------------------|
| id         | UUID (PK) | Unique alert identifier            |
| user_id    | UUID (FK) | References `users.id`              |
| crop_id    | UUID (FK) | References `crops.id`              |
| alert_text | TEXT      | Description of the issue          |
| alert_type | ENUM      | `disease`, `task_reminder`        |
| created_at | TIMESTAMP | Alert creation timestamp          |

## 3. Physical Design

### DBMS Selection
- **PostgreSQL**, hosted on **Neon**.
- **Authentication & Authorization**: Supabase for seamless management.