# Personal-Finance-and-Budgeting-API
Made by Prohor Muchev 5515

## Introduction

-This API facilitates personal finance management and budgeting, enabling users to track expenses, create budget plans, set financial goals, and monitor progress towards those goals. It provides CRUD operations for managing budget plans and financial goals efficiently. You can run the code in Intellij IDEA and you can use the URL commands in the COMMANDS.http file located inside the project directory instead of using Postman to interact with the API.

## Base URL

http://localhost:8080/api/ (insert a specific endpoint here)


## Endpoints (replace {id} with a number)
## Budget Commands:
1. **Create a New Budget:**
   - **HTTP Method**: POST
   - **Endpoint**: `/budgets`
   - **Description**: Allows users to create new budget plans with specified names and amounts.
   - **Request Headers**:
     - Content-Type: application/json
   - **Request Body**:
		```json
		{
		  "name": "Groceries",
		  "amount": 300.00
		}
		```
   - **Responses**:
     - 201 Created:
		```json
		{
		 "id": 1,
		 "name": "Groceries",
		 "amount": 300.00
		}
		```
	  - 400 Bad Request: Invalid input

2. **View All Budgets:**
   - **HTTP Method**: GET
   - **Endpoint**: `/budgets`
   - **Description**: Retrieve all existing budget plans.
   - **Request Headers**:
     - Accept: application/json
   - **Responses**:
     - 200 OK:
		```json
		[
		  {
		    "id": 1,
		    "name": "Groceries",
		    "amount": 300.00
		  },
		  {
		    "id": 2,
		    "name": "Rent",
		    "amount": 1000.00
		  }
		]
		```
	  - 204 No Content: No budgets found
3. **Retrieve a Budget by ID:**
    -   **HTTP Method**: GET
    -   **Endpoint**: `/budgets/{id}`
    -   **Description**: Retrieve details of a single budget plan by its ID.
    -   **Path Parameters**:
        -   id (integer): ID of the budget plan
    -   **Responses**:
        -   200 OK:
			```json
			{
			  "id": 1,
			  "name": "Groceries",
			  "amount": 300.00
			}
			```
	    - 404 Not Found: Budget not found
4. **Update a Budget:**
	-   **HTTP Method**: PUT
	-   **Endpoint**: `/budgets/{id}`
	-   **Description**: Update details of an existing budget plan, including its name and 		amount.
	-   **Request Headers**:
	    -   Content-Type: application/json
	-   **Path Parameters**:
	    -   id (integer): ID of the budget plan
	- **Request Body**:
		```sql
		{
		  "name": "Groceries",
		  "amount": 350.00
		}
		```
	- **Responses**:
      - 200 OK:
		```sql
		{
		  "id": 1,
		  "name": "Groceries",
		  "amount": 350.00
		}
		```
	  -   400 Bad Request: Invalid input
	  -   404 Not Found: Budget not found
	  
5. **Delete a Budget:**
	-   **HTTP Method**: DELETE
	-   **Endpoint**: `/budgets/{id}`
	-   **Description**: Delete an existing budget plan.
	-   **Path Parameters**:
	    -   id (integer): ID of the budget plan
	-   **Responses**:
	    -   204 No Content: Successfully deleted
	    -   404 Not Found: Budget not found
## Goal Commands:
1. **Create a New Goal:**
	-   **HTTP Method**: POST
	-   **Endpoint**: `/goals`
	-   **Description**: Allows users to create new financial goals with specified names, target amounts, and current amounts.
	-   **Request Headers**:
	    -   Content-Type: application/json
	-   **Request Body**:
		```json
		{
		  "name": "Vacation",
		  "targetAmount": 2000.00,
		  "currentAmount": 500.00,
		  "description": "I need a good vacation."
		}
		```
	- **Responses**:
      - 201 Created:
		```json
		{
		  "id": 1,
		  "name": "Vacation",
		  "targetAmount": 2000.00,
		  "currentAmount": 500.00,
		  "description": "I need a good vacation."
		}
		```
	  - 400 Bad Request: Invalid input
2. **View All Goals:**
	-   **HTTP Method**: GET
	-   **Endpoint**: `/goals`
	-   **Description**: Retrieve all existing financial goals.
	-   **Request Headers**:
	    -   Accept: application/json
	-   **Responses**:
	    -   200 OK:
			```json
			[
			  {
			    "id": 1,
			    "name": "Vacation",
			    "targetAmount": 2000.00,
			    "currentAmount": 500.00
			    "description": "I need a good vacation."
			  },
			  {
			    "id": 2,
			    "name": "Emergency Fund",
			    "targetAmount": 5000.00,
			    "currentAmount": 1000.00
			    "description": "This is for an emergency fund."
			  }
			]
			```
		- 204 No Content: No goals found
		
3. **Retrieve a Goal by ID:**
	-   **HTTP Method**: GET
	-   **Endpoint**: `/goals/{id}`
	-   **Description**: Retrieve details of a single financial goal by its ID.
	-   **Path Parameters**:
	    -   id (integer): ID of the financial goal
	-   **Responses**:
	    -   200 OK:
			```json
			{
			  "id": 1,
			  "name": "Vacation",
			  "targetAmount": 2000.00,
			  "currentAmount": 500.00,
			  "description": "I need a good vacation."
			}
			```
		 - 404 Not Found: Goal not found
4. **Update a Goal:**
	-   **HTTP Method**: PUT
	-   **Endpoint**: `/goals/{id}`
	-   **Description**: Update details of an existing financial goal, including its name, target amount, and current amount.
	-   **Request Headers**:
	    -   Content-Type: application/json
	-   **Path Parameters**:
	    -   id (integer): ID of the financial goal
	-   **Request Body**:
		```json
		{
		  "name": "Vacation",
		  "targetAmount": 2500.00,
		  "currentAmount": 600.00,
		  "description": "I need a good vacation."
		}
		```
	- **Responses**:
	  - 200 OK:
		```json
		{
		  "id": 1,
		  "name": "Vacation",
		  "targetAmount": 2500.00,
		  "currentAmount": 600.00,
		  "description": "I need a good vacation."
		}
		```
	  -   400 Bad Request: Invalid input
	  -   404 Not Found: Goal not found
5. **Delete a Goal:**
    -   **HTTP Method**: DELETE
    -   **Endpoint**: `/goals/{id}`
    -   **Description**: Delete an existing financial goal.
    -   **Path Parameters**:
        -   id (integer): ID of the financial goal
    -   **Responses**:
        -   204 No Content: Successfully
        -   404 Not Found: Goal not found

## H2 Database:
-My API uses an H2 Database for storing the data and you can access the console with the following link:

http://localhost:8080/h2-console

-On the H2 console login page, use the following settings:

-   **JDBC URL**: `jdbc:h2:mem:finance`
-   **User Name**: `sa`

-Then just click the "Connect" button and you can start messing around with the database.
## SQL Querie Command Examples:
-Here are some SQL querie command examples that you can use in the H2 Database Console:
### Show All Tables:
```sql
SHOW TABLES;
```
## Budget Table Commands (replace {id} with a number):
  
1.  **Insert a New Budget:**
	```sql
	     INSERT INTO BUDGET (name, amount) VALUES ('Groceries', 300.00);
	```
2.  **Get All Budgets:**
	```sql
	    SELECT * FROM BUDGET;
	```
3.  **Retrieve a Budget by ID:**
	```sql
	    SELECT * FROM BUDGET WHERE id = {id}; 
	```   
4.  **Update a Budget:**
	```sql
	    UPDATE BUDGET SET name = 'Groceries', amount = 350.00 WHERE id = {id}; 
	```    
5.  **Delete a Budget:**
	```sql
	    DELETE FROM BUDGET WHERE id = {id}; 
	 ```

## Goal Table Commands (replace {id} with a number):

1.  **Insert a New Goal:** 
	```sql
	    INSERT INTO GOAL (name, target_amount, current_amount) VALUES ('Vacation',2000.00, 500.00);
	```    
2.  **Get All Goals:**
	```sql
	    SELECT * FROM GOAL; 
	```    
3.  **Retrieve a Goal by ID:**
	```sql
	    SELECT * FROM GOAL WHERE id = {id}; 
	```    
4.  **Update a Goal:**
	```sql
	    UPDATE GOAL SET name = 'Vacation', target_amount = 2500.00, current_amount = 600.00 WHERE id = {id}; 
	```    
5.  **Delete a Goal:**
	```sql
	    DELETE FROM GOAL WHERE id = {id};
	```
## Additional SQL Querie Command Examples:

-**Get budgets with an amount greater than a specified value:**:
```sql
SELECT  *  FROM BUDGET WHERE amount >  500.00;
```
-**Get goals with a specific target amount range:**:
```sql
SELECT  *  FROM GOAL WHERE target_amount BETWEEN  1000.00  AND  3000.00;
```
