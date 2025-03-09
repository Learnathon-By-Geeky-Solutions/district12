## APIs For Alert Management

## Get Minimal Information of Alert by ID

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/{alertId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/{alertId}`

**Parameters:**
```json
{
  "alertId": 1
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns alert details for the given ID.

```json
{
  "id": 1,
  "userId": 1,
  "alertType": "CROP",
  "alertPriority": "LOW",
  "createdAt": "2025-03-09T14:30:45.123",
  "readAt": "2025-03-09T14:30:45.123+06:00[Asia/Dhaka]"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

## Get Detailed Alert by ID

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/details/{alertId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/details/{alertId}`

**Parameters:**
```json
{
  "alertId": 1
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns detailed information for the alert with the given ID.

```json
{
  "id": 1,
  "userId": 1,
  "alertType": "CROP",
  "alertPriority": "LOW",
  "createdAt": "2025-03-09T14:30:45.123",
  "readAt": "2025-03-09T14:30:45.123",
  "details": {
    "cropId": 1,
    "userCropId": 2,
    "cropName": "Rice",
    "cropAlertType": "DROUGHT_STRESS"
  }
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

## Get All Alerts by Type (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/type/{alertType}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/type/{alertType}`

**Parameters:**
```json
{
  "alertType": "TASK"
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of alerts filtered by the given type(CROP, TASK, WEATHER).

```json
[
  {
    "id": 1,
    "userId": 1,
    "alertType": "TASK",
    "alertPriority": "MEDIUM",
    "createdAt": "2025-03-09T14:30:45.123",
    "readAt": "2025-03-09T14:30:45.123",
    "details": {
      "taskType": "SEED_PLANTING",
      "dueTime": "2025-03-09T14:30:45.123"
    }
  }
]
```

### ❌ Error Response:
**Status Code:** `500 Internal Server Error`
```json
{
  "error": "Something went wrong."
}
```

## Get All Alerts by User ID (ADMIN/OFFICER)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/type/{userId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/type/{userId}`

**Parameters:**
```json
{
  "userId": 2
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of all alerts for the given user.

```json
[
  {
    "id": 1,
    "userId": 1,
    "alertType": "WEATHER",
    "alertPriority": "VERY_HIGH",
    "createdAt": "2025-03-09T14:30:45.123",
    "readAt": "2025-03-09T14:30:45.123",
    "details": {
      "weatherType": "HUMIDITY_FLUCTUATION",
      "forecastedAt": "2025-03-09T14:30:45.123"
    }
  }
]
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "No alerts found for the specified user."
}
```

## Get Unread Alerts by User ID

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/user/un-read`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/user/un-read`

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns all unread alerts for the authenticated user.

```json
[
  {
    "id": 1,
    "userId": 1,
    "alertType": "WEATHER",
    "alertPriority": "VERY_HIGH",
    "createdAt": "2025-03-09T14:30:45.123",
    "readAt": "2025-03-09T14:30:45.123",
    "details": {
      "weatherType": "HUMIDITY_FLUCTUATION",
      "forecastedAt": "2025-03-09T14:30:45.123"
    }
  }
]
```

### ❌ Error Response:
**Status Code:** `401 Unauthorized`
```json
{
  "error": "User authentication required."
}
```

## Mark Alert as Read by User

---

**Endpoint:**  
`PUT https://server.district12.xyz/v1/alert/user/mark-read/{alertId}`

**Local Dev Endpoint:**  
`PUT http://localhost:8080/v1/alert/user/mark-read/{alertId}`

**Parameters:**
```json
{
  "alertId": 3
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Marks the alert as read.

```json
{
  "success" : true,
  "message": "Alert marked as read successfully."
}
```

### ❌ Invalid Request:
**Status Code:** `404 Not Found`
```json
{
  "success" : false,
  "message": "No such alert found"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

## Mark Multiple Alerts as Read by User

---

**Endpoint:**  
`POST https://server.district12.xyz/v1/alert/user/mark-read`

**Local Dev Endpoint:**  
`POST http://localhost:8080/v1/alert/user/mark-read`

**Request Body:**
```json
{
  "alertIds": [1, 2, 3]
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Marks the specified alerts as read.

```json
{
  "success" : true,
  "message": "Alerts marked as read successfully."
}
```

### ❌ Invalid Request:
**Status Code:** `404 Not Found`
```json
{
  "success" : false,
  "message": "No such alerts found"
}
```

### ❌ Error Response:
**Status Code:** `400 Bad Request`
```json
{
  "error": "error message."
}
```

## Delete Alert by ID

---

**Endpoint:**  
`DELETE https://server.district12.xyz/v1/alert/delete/{alertId}`

**Local Dev Endpoint:**  
`DELETE http://localhost:8080/v1/alert/delete/{alertId}`

**Parameters:**
```json
{
  "alertId": 1
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Deletes the alert with the given ID.

```json
{
  "success" : true,
  "message": "Alert deleted successfully.."
}
```

### ❌ Invalid Request:
**Status Code:** `404 Not Found`
```json
{
  "success" : false,
  "message": "Alert deletion not successful"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```
