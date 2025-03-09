# APIs For Alert Management

## Get All Alerts by Crop Alert Type (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/crop/type/{cropAlertType}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/crop/type/{cropAlertType}`

**Parameters:**
```json
{
  "cropAlertType": "DRAUGHT_STRESS"
}
```

### ✅ Success Response:

**Status Code:** `200 OK`  
Returns a list of all crop alerts filtered by the given type.

```json
[
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
]
```

### ❌ Error Response:

**Status Code:** `404 Not Found`

```json
{
  "status": "error",
  "error": "error message"
}
```

## Get All Alerts by Crop ID (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/crop/id/{cropId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/crop/id/{cropId}`

**Parameters:**
```json
{
  "cropId": 4
}
```

### ✅ Success Response:

**Status Code:** `200 OK`  
Returns a list of all crop alerts associated with the specified crop ID.

```json
[
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
]

```

### ❌ Error Response:

**Status Code:** `404 Not Found`

```json
{
  "status": "error",
  "message": "No alerts found for the specified crop ID."
}
```

## Create New Crop Alert (Admin/Officer)

---

**Endpoint:**  
`POST https://server.district12.xyz/v1/alert/crop/create`

**Local Dev Endpoint:**  
`POST http://localhost:8080/v1/alert/crop/create`

**Request Body:**

```json
{
  "userId": 1,
  "alertType": "CROP",
  "alertPriority": "LOW",
  "cropAlertType": "DROUGHT_STRESS",
  "userCropId": 2
}
```

### ✅ Success Response:

**Status Code:** `201 Created`  
Creates a new crop alert and returns its details.

```json
{
  "id": 1,
  "userId": 1,
  "alertType": "CROP",
  "alertPriority": "LOW",
  "createdAt": "2025-03-09T14:30:45.123",
  "readAt": null,
  "details": {
    "cropId": 1,
    "userCropId": 2,
    "cropName": "Rice",
    "cropAlertType": "DROUGHT_STRESS"
  }
}
```

### ❌ Error Response:

**Status Code:** `400 Bad Request`

```json
{
  "status": "error",
  "message": "Invalid crop alert request."
}
```
