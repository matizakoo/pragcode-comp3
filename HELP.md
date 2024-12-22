# API Documentation

# Introduction
Application uses **Java 17** and **H2 Database** <br>
To run application use
> mvn spring-boot:run

default port: *8080*

### 1. Start a New Session

**Endpoint:**  
`GET /api/startNewSession`

**Description:**  
This endpoint is used to create a new session. The session can remain up to 5 minutes, after which it will automatically be removed.

**Example response**
```json
Cart with 2f4a978932c84c has been created. Use the sessionId to identify your shopping cart.
```
---

### 2. Add a New Product

**Endpoint:**  
`POST /api/add`

**Request Headers:**
- `sessionId` (String) - Mandatory. The unique identifier for the current session.

**Request Parameters:**
- `productCode` (String) - Mandatory. The code of the product to be added. Valid product codes are defined in the `V1__dump.sql` file and range from `Item1` to `Item20`.
- `quantity` (Integer) - Optional. The quantity of the product to be added. If not provided, it defaults to `1`.

**Response:**  
Returns a `ResponseEntity` containing a `HashMap<String, Integer>` with the product details and the updated quantity.
```json
{
    "Item13": 7
}
```

**Exceptions:**
- If the `productCode` or `sessionId` does not exist, an exception will be thrown.

**Example Request:**
```http
POST /add
Headers:
  sessionId: 2f4a978932c84c
Params:
  productCode=Item5
  quantity=2
```
### 3. Checkout

**Endpoint:**  
`GET /api/checkout`

**Description:**  
This endpoint completes the purchase process and returns a summary in the form of a receipt.

**Request Headers:**
- `sessionId` (String) - Mandatory. The unique identifier for the current session.

**Response:**  
Returns a `SummaryDTO` containing:
- `sessionId` (String): The session ID.
- `listOfItems` (List<ItemDTO>): A list of items purchased in the session.

Each `ItemDTO` includes:
- `name` (String): The name of the item.
- `quantity` (Integer): The quantity of the item purchased.
- `finalPrice` (Float): The final price of the item after applying all  promotions.

**Example Request:**
```http
GET /api/checkout
Headers:
  sessionId: abc123
```

**Example response**
```json
{
"sessionId": "2f4a978932c84c",
"listOfItems": [
    {
        "name": "Item5",
        "quantity": 2,
        "finalPrice": 20
    },
    {
        "name": "Item10",
        "quantity": 1,
        "finalPrice": 3
    }
]
}
```
## 4. Scan Product

**Endpoint:**  
`GET /api/scan`

**Description:**  
This endpoint retrieves information about a product based on its code. It provides details such as the product's ID, regular price, and any promotional offers if available.

**Request Headers:**
- `productCode` (String) - Mandatory. The code of the product to be scanned.

**Response:**  
Returns an `OfferDTO` containing:
- `id` (Integer): The unique identifier of the product.
- `item` (String): The name of the product.
- `normalPrice` (Float): The regular price of the product.
- `requiredQuantity` (Integer): The quantity required to activate a promotional price (if any).
- `specialPrice` (Float): The promotional price available when the required quantity is purchased.

**Example Request:**
```http
GET /scan
Headers:
  productCode: Item10
```

** Example response: **
```json
{
    "id": 10,
    "item": "Item10",
    "normalPrice": 100.0,
    "requiredQuantity": null,
    "specialPrice": null
}
```
