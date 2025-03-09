# APIs For Alert Management

## Get All Alerts by Crop Alert Type (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/crop/type/{cropAlertType}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/crop/type/{cropAlertType}`

**Parameters:**
- `cropAlertType` (string, required): The type of crop alert to filter by. Example: `DROUGHT_STRESS`

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of all crop alerts filtered by the given type.

```json
{
  "status": "success",
  "alerts": [
    {
      "id": 1,
      "cropId": 10,
      "cropAlertType": "DROUGHT_STRESS",
      "alertPriority": "HIGH",
      "createdAt": "2025-03-09T14:30:45.123",
      "details": {
        "cropName": "Rice",
        "affectedArea": "Northern Region"
      }
    }
  ]
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "status": "error",
  "message": "No alerts found for the specified crop alert type."
}
```

## Get All Alerts by Crop ID (Admin/Officer)

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/alert/crop/id/{cropId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/alert/crop/id/{cropId}`

**Parameters:**
- `cropId` (integer, required): The crop ID to filter alerts by. Example: `10`

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of all crop alerts associated with the specified crop ID.

```json
{
  "status": "success",
  "alerts": [
    {
      "id": 1,
      "cropId": 10,
      "cropAlertType": "PEST_INFESTATION",
      "alertPriority": "MEDIUM",
      "createdAt": "2025-03-09T14:30:45.123",
      "details": {
        "cropName": "Wheat",
        "pestType": "Locust"
      }
    }
  ]
}
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
  "cropId": 10,
  "cropAlertType": "FLOOD_RISK",
  "alertPriority": "VERY_HIGH",
  "details": {
    "affectedArea": "Southern Region"
  }
}
```

### ✅ Success Response:
**Status Code:** `201 Created`  
Creates a new crop alert and returns its details.

```json
{
  "status": "success",
  "alert": {
    "id": 2,
    "cropId": 10,
    "cropAlertType": "FLOOD_RISK",
    "alertPriority": "VERY_HIGH",
    "createdAt": "2025-03-09T14:30:45.123",
    "details": {
      "affectedArea": "Southern Region"
    }
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
