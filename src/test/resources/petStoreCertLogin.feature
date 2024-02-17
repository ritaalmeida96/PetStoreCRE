@Login
Feature: Login Feature Pet Store Website
  I want to test the Login Feature on the Pet Store Website


  Scenario Outline: Test Login with valid data
    Given I am at the Pet Store Login page using "<browser>"
    When I enter a valid username and password
    And I click on the Login 
    Then I should be redirected to the home page

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 
