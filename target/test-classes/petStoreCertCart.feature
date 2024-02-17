@Cart
Feature: Cart Feature Pet Store Website
  I want to test the Cart Feature on the Pet Store Website


  Scenario Outline: Add to Cart Feature
    Given I am logged and able to search a product using "<browser>"
    When I click on the Add to Cart
    Then The item added is shown at shopping cart

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 
