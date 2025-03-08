## APIs For Alert Management

### Get Alert by ID

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
  "type": "Security",
  "message": "Suspicious activity detected",
  "status": "Unread"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

### Get Detailed Alert by ID

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
  "type": "Security",
  "message": "Suspicious activity detected",
  "detailedMessage": "Multiple login attempts detected from an unusual IP address.",
  "status": "Unread",
  "timestamp": "2025-03-09T12:00:00Z"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

### Get All Alerts by Type (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/type/{alertType}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/type/{alertType}`

**Parameters:**
```json
{
  "alertType": "Security"
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of alerts filtered by the given type.

```json
[
  {
    "id": 1,
    "type": "Security",
    "message": "Suspicious activity detected",
    "status": "Unread"
  },
  {
    "id": 2,
    "type": "Security",
    "message": "Unusual login attempt",
    "status": "Read"
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

### Get All Alerts by User ID (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/type/{userId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/type/{userId}`

**Parameters:**
```json
{
  "userId": 123
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of alerts for the given user.

```json
[
  {
    "id": 1,
    "type": "Security",
    "message": "Suspicious activity detected",
    "status": "Unread"
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

### Get Unread Alerts by User ID

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
    "type": "Security",
    "message": "Suspicious activity detected",
    "status": "Unread"
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

### Mark Alert as Read by User

---

**Endpoint:**  
`PUT https://server.district12.xyz/v1/alert/user/mark-read/{alertId}`

**Local Dev Endpoint:**  
`PUT http://localhost:8080/v1/alert/user/mark-read/{alertId}`

**Parameters:**
```json
{
  "alertId": 1
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Marks the alert as read.

```json
{
  "message": "Alert marked as read successfully."
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```

### Mark Multiple Alerts as Read by User

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
  "message": "Alerts marked as read successfully."
}
```

### ❌ Error Response:
**Status Code:** `400 Bad Request`
```json
{
  "error": "Invalid alert IDs provided."
}
```

### Delete Alert by ID

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
  "message": "Alert deleted successfully."
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Alert not found."
}
```
