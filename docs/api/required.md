# List of All Intended APIs

## Authentication & User Management

### User Registration
**POST** `/api/auth/register`
Register a new user and return JWT token

### User Login
**POST** `/api/auth/login`  
Authenticate users and return JWT token

### User Logout
**POST** `/api/auth/logout`  
Invalidate JWT session

### Get User Profile
**GET** `/api/users/{userId}`  
Fetch user details

### Update User Profile
**PUT** `/api/users/{userId}`  
Update user details (name, email, etc.)

### Delete User Account
**DELETE** `/api/users/{userId}`  
Soft delete/permanently delete user

## Crop Selection

### Fetch Available Crops
**GET** `/api/crops`  
Fetch all available crops

### Select Crops
**POST** `/api/user-crops`  
User selects multiple crops for planning

### Deselect Crops
**POST** `/api/user-crops/{userId}/{cropId}`  
POST request since body is needed for batch deletion
Remove crop from the user’s selection

## Daily Logs (Elasticsearch)

### Submit Daily Log
**POST** `/api/daily-log/{userId}`  
Users log daily activities for their crops

### Fetch User’s Daily Logs
**GET** `/api/daily-log/{userId}`  
Retrieve all logs of a user

### Delete Daily Log (Admin Only ?)
**DELETE** `/api/daily-log/{userId}/{logId}`
Allow users to delete a specific log entry.
## Chat System

### Start a Chat Session
**POST** `/api/chat-sessions`  
Create a chat session between user and officer

### Send a Message
**POST** `/api/chats`  
Send a message (text/attachment)

### Upload Chat Attachment
**POST** `/api/chat-attachments`  
Upload an image/document as an attachment

## Broad Data Visualization (Elasticsearch) (Both Admin and Local Officer)

### Generate Data Report
**POST** `/api/data-visualization`  
Generate aggregated farming insights for an officer

### Fetch Data Reports
**GET** `/api/data-visualization/{officerId}`  
Fetch previously generated reports

## Alerts & Notifications

### Create an Alert
**POST** `/api/alert`
Officer/user creates a disease or weather alert

### Fetch Unread Alerts for A User
**GET** `/api/alerts/{userId}/unread`
Fetch all unread alerts for a user.

### Mark Alert as Read
**PATCH** `/api/alerts/{alertId}/read`
Mark an alert as read by the user.

### Fetch All Alerts for A User
**GET** `/api/alerts/{userId}`
Fetch all alerts for a user.

### Delete an Alert
**DELETE** `/api/alert/{alertId}`  
Remove an alert

### Delete multiple Alerts
**DELETE** `/api/alerts`  
Remove multiple alerts

## Administrative APIs (Admin Only)

### Local Officer Registration
**POST** `/api/admin/register/officer`  
Register a new local officer

### Delete Any User
**DELETE** `/api/admin/user/{userId}`  
Admin deletes any user account

### Delete Any Officer
**DELETE** `/api/admin/officer/{userId}`  
Admin deletes any officer account

## Weather APIs

### Fetch Real-time Weather Information
**GET** `/api/weather/now`  
Fetch real-time temperature, humidity and similars.

### Fetch Weather Forecast Information
**GET** `/api/weather/forecast`  
Fetch temperature, humidity and similar information for upcoming days.