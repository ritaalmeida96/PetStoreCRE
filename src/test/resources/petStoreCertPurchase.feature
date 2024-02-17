@Purchase
Feature: Purchase Feature Pet Store Website
  I want to test the Purchase Feature on the Pet Store Website


  Scenario Outline: Make purchase on the website
    Given I am able to login using "<browser>"
    And I can add a product to my Cart
    When I click on Proceed to checkout
    And fill and confirm all the required information
    Then I see an order confirmation

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 
