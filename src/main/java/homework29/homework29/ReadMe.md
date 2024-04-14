## SWAGGER

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## API Calls

### Ping
**Method:** GET  
**Endpoint:** ```localhost:8080/ping```

### Get All Orders
**Method:** GET  
**Endpoint:** ```localhost:8080/orders```

### Post Call. Add new order with a body
**Method:** POST  
**Endpoint:** ```localhost:8080/add```  
**Content-Type:** application/json

```
[
{
"id": 0,
"name": "test1",
"cost": 75
}
]
```

### Get Order by Id
**Method:** GET  
**Endpoint:** ```localhost:8080/order/1```
