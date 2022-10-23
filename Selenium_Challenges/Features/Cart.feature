Feature: User is able to add items to cart

Background: User should login before performing each scenario
Given User clicks on the sign in button
When User enters username and password
And user clicks on the login button
Then user is able to sign in

#Handle dynamic object and handle drop down
Scenario: User clicks on an item from the homepage and adds the item to the cart
When User clicks on the first item
And User selects the quantity
And User clicks on Add to Cart button
Then the correct quantity is displayed

#Handle Mouse Hover
Scenario: User can hover over their username
Given User clicks on the profile
When User hovers over their profile



