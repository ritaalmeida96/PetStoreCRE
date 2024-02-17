@Register
Feature: Register Feature Pet Store Website
  I want to test the Register Feature on the Pet Store Website


  Scenario Outline: Test Register with valid data
     Given I am at the Pet Store Register page using "<browser>"
     When I enter valid user and account information
     And I click on Save Account 
     Then I should be redirected from Register to the home page

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 