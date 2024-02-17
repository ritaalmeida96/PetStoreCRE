@Product
Feature: Product Search Feature Pet Store Website
  I want to test the Product Search on the Pet Store Website


  Scenario Outline: Test Search Product
    Given I am Logged into Pet Store using "<browser>"
    When I search for a product and press ENTER
    And I open a product from the search result
    Then I have the product detail information

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 
