@Cancel
Feature: CancelOrder Endpoint
Scenario:  Get User logtoken from login endpoint

    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User should verify the login response body firstName present as "{First Name}" and get the logtoken saved

Scenario:  Verify User clear cart through api

    Given User add header and bearer authorization for accessing clear cart endpoints
    When User send "GET" request for clear cart endpoint
    Then User should verify the status code is 400
    And User should verify the response message "Currently Your Cart is empty"

 Scenario: Verify User get Category List through api

    Given User add headers for category List
    When User send "GET" request for category List endpoint
    Then User should verify the status code is 200
   And User should verify the category List response message matches "OK" and get the category id of main category Name "Grocery" and the sub category Name of "Fruit & Nuts" saved


 Scenario:  Verify User get Product List through api

    Given User add headers for product List
    When User add request body for product list with category_id and page no "0"
    And User send "POST" request for product List endpoint
    Then User should verify the status code is 200
    And User should verify the product List response message matches "OK" with product name of "Happilo 100% Natural Premium California Almonds | Premium Badam Giri"  and save variant id with specifications "500 g"

  Scenario:  Verify User add to cart through api

    Given User add header and bearer authorization for accessing add to cart endpoints
    When User add request body for add to cart
    And User send "POST" request for add to cart endpoint
    Then User should verify the status code is 200
    And User should verify the add to cart response message matches "Product added in cart"

 Scenario: Verify User get cart through api

    Given User add header and bearer authorization for accessing get cart endpoints
    When User send "GET" request for get cart endpoint
    Then User should verify the status code is 200
    And User should verify the get cart response message matches "OK" and save the cart id

 Scenario Outline: Verify add user address to the application through api

    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>",and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully" and save the address id

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |

 Scenario: Verify User set address through api

    Given User add header and bearer authorization for accessing set address endpoints
    When User add request body for set address product
    And User send "POST" request for set address endpoint
    Then User should verify the status code is 200
    And User should verify the set address response message matches "Cart updated successfully"

 Scenario Outline: Verify User able to create Order

    Given User add header and bearer authorization for accessing create order endpoints
    When User add request body for create order product
      | Select card | CardNo           | CardName      | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name     | March | 2024 | 123 |
      | Mastercard  | 5555555555554444 | Your name     | March | 2024 | 123 |
      | Amex        | 5555555555550000 | Your name     | March | 2024 | 123 |
      | Discover    | 5555555555556666 | Your name     | March | 2024 | 123 |
    And User send "POST" request for create order endpoint
    Then User should verify the status code is 200
    And User should verify the create order response message matches "Order created successfully" and save the order id

 Scenario: Verify User able to cancel Order

    Given User add header and bearer authorization for accessing cancel Order endpoints
    When User add request body for cancel Order
    And User send "POST" request for cancel order endpoint
    Then User should verify the status code is 200
    And User should verify the cancel order response message matches "Order has been cancelled. Amount will be refunded after admin approves the request"
