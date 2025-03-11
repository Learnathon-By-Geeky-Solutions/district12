# APIs For Crop Management

## Get a List of All Available Crops

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/crops`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/crops`

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns a list of available crops.

```json
[
    {
      "id": 1,
      "name": "Wheat",
      "description": "A cereal grain used for bread and pasta"
    },
    {
      "id": 2,
      "name": "Rice",
      "description": "A staple food for many countries"
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

## Get Crop Details by ID

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/crops/{cropId}`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/crops/{cropId}`

**Parameters:**
```json
{
  "cropId": 1
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Returns details of the crop with given ID

```json
{
  "id": 1,
  "name": "Wheat",
  "description": "A cereal grain used for bread and pasta"
}
```

### ❌ Error Response:
**Status Code:** `404 Not Found`
```json
{
  "error": "Crop not found."
}
```

## Select Crops for a User

---

**Endpoint:**  
`POST https://server.district12.xyz/v1/crops/user/select`

**Local Dev Endpoint:**  
`POST http://localhost:8080/v1/crops/user/select`

**Request Body:**
```json
{
  "cropIds": [1, 2, 3]
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Stores selected crops against user in database

```json
[
  {
    "id": 1,
    "name": "Wheat",
    "description": "A cereal grain used for bread and pasta"
  },
  {
    "id": 2,
    "name": "Rice",
    "description": "A staple food for many countries"
  }
]
```

### ❌ Error Response:
**Status Code:** `400 Bad Request`
```json
{
  "error": "Invalid crop IDs provided."
}
```

## Get User's Selected Crops

---

**Endpoint:**  
`GET https://server.district12.xyz/v1/crops/user`

**Local Dev Endpoint:**  
`GET http://localhost:8080/v1/crops/user`

### ✅ Success Response:
**Status Code:** `200 OK`  
Fetches selected crops by user from database

```json
[
  {
    "id": 1,
    "name": "Wheat",
    "description": "A cereal grain used for bread and pasta"
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

## Deselect Crops for a User

---

**Endpoint:**  
`POST https://server.district12.xyz/v1/crops/user/deselect`

**Local Dev Endpoint:**  
`POST http://localhost:8080/v1/crops/user/deselect`

**Request Body:**
```json
{
  "cropIds": [1]
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Removes selected crops against user from database

```json
[
  {
    "id": 2,
    "name": "Rice",
    "description": "A staple food for many countries"
  }
]
```

### ❌ Error Response:
**Status Code:** `400 Bad Request`
```json
{
  "error": "Invalid crop IDs provided."
}
```

## Authorized Admin/Officer Add a New Crop to Database

---

**Endpoint:**  
`POST https://server.district12.xyz/v1/crops/add`

**Local Dev Endpoint:**  
`POST http://localhost:8080/v1/crops/add`

**Request Body:**
```json
{
  "name": "Asparagus",
  "description": "From the story - The Luncheon"
}
```

### ✅ Success Response:
**Status Code:** `201 OK`  
Added new crop to database

```json
[
  {
    "id": 12,
    "name": "Asparagus",
    "description": "From the story - The Luncheon"
  }
]
```

### ❌ Error Response:
**Status Code:** `400 Bad Request`
```json
{
  "error": "error message"
}
```

## Authorized Admin/Officer Deletes a Crop from Database

---

**Endpoint:**  
`DELETE https://server.district12.xyz/v1/crops/delete`

**Local Dev Endpoint:**  
`DELETE http://localhost:8080/v1/crops/delete`

**Parameters:**
```json
{
  "cropId": 8
}
```

### ✅ Success Response:
**Status Code:** `200 OK`  
Deleted crop from database

### ❌ Error Response:
**Status Code:** `404 Not found`
```json
{
  "error": "error message"
}
```