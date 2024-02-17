# PetStoreCRE

## Overview

This project implements automated tests for an e-commerce website called Pet Store using Selenium WebDriver. The tests cover various functionalities such as user registration, login, product search, adding items to the cart, and checkout process.

## Features

- User registration
- User login
- Product search and display
- Adding items to the cart
- Checkout process


## Requirements

- Java JDK 8 or higher
- Maven
- WebDriver for your preferred browser (Chrome, Firefox, etc.)

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ritaalmeida96/PetStoreCRE.git
   ```

2. **Install dependencies:**

   ```bash
   cd PetStoreCRE
   mvn clean install
   ```

## Running Tests

### Locally

```bash
mvn clean test
//runs all available browsers
```

### On Specific Browsers

#### Chrome

```bash
mvn test -Dbrowser=chrome
```

#### Firefox

```bash
mvn test -Dbrowser=firefox
```

## Folder Structure

```
PetStoreCRE/
│
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   └── Config/
│       │   │   ├── WebDriverConfig.java/
│       │   └── Helpers/
│       │   │   ├── Helper.java/
│       │   │   ├── PageManager.java/
│       │   │   └── ProductManager.java/
│       │   └── PageObjects/
│       │   │   ├── CartPage.java/
│       │   │   ├── LoginPage.java/
│       │   │   ├── ProductPage.java/
│       │   │   ├── PurchasePage.java/
│       │   │   └── RegisterPage.java/
│       │   └── PetStoreCertBDD/
│       │   │   └── TestRunner.java/
│       │   └── PetStoreCertfBDD.steps/
│       │   │   ├── PetStoreCartTest.java/
│       │   │   ├── PetStoreLoginTest.java/
│       │   │   ├── PetStoreProductTest.java/
│       │   │   ├── PetStorePurchasetTest.java/
│       │   │   └── PetStoreRegisterTest.java/
│       └── resources/
│       │   │   ├── PetStoreCart.feature/
│       │   │   ├── PetStoreLogin.feature/
│       │   │   ├── PetStoreProduct.feature/
│       │   │   ├── PetStorePurchase.feature/
│       │   │   └── PetStoreRegister.feature/
│       └── drivers/
│           ├── chromedriver.exe
│           └── geckodriver.exe
│           
│
├── .gitignore
├── pom.xml
```

## Gherkin Files per Feature

## Register Feature
```gherkin
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
```

## Login Feature
```gherkin
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
```

## Search for Product
```gherkin
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
```

## Add To Cart
```gherkin
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
```

## Final Purchase
```gherkin
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
```

## Test Reports

Test reports are generated using Allure Report in Jenkins Pipeline.

![Allure Report Dashboard](https://github.com/ritaalmeida96/PetStoreCRE/blob/main/images/allure%20report%201.png)

![Allure Report Test Results](https://github.com/ritaalmeida96/PetStoreCRE/blob/main/images/allure%20report%202.png)

## Continuous Integration

The project was integrated with Jenkins for automated test execution.

![Jenkins Dashboard](https://github.com/ritaalmeida96/PetStoreCRE/blob/main/images/Jenkins_Integration1.png)

![Jenkins Dashboard](https://github.com/ritaalmeida96/PetStoreCRE/blob/main/images/Jenkins_Integration2.png)

