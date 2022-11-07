Feature: User is able to Retrieve product information as well as post new products, 
edit products, and delete the products with API

Background: User Generates token for authorization
Given User generates a token

#Get Method
Scenario: The Authorized admin user can Get all Products.

When Get method is used for endpoint 
Then All the products are retrieved
And The status code is 200 Ok
And The response time is below 500 ms


#Post Method
Scenario: The Authorized admin user can Post new Product.

When Post method is used for endpoint
Then Sample product is posted to the application
And The status code is 201 Created
And The response time is below 500 ms


#Put Method
Scenario: The Authorized admin user Update a new Product.

When Put method is used for endpoint
Then Sample product is updated in the application
And The status code is 201 Created
And The response time is below 500 ms


#Delete Method
Scenario: The Authorized admin user can Delete a new Product.

When Delete method is used for endpoint
Then Sample product is removed from the application
And The status code is 200 Ok
And The response time is below 500 ms