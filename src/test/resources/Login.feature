Feature: Login Functionality

  In order to do internet banking
  As a valid Para bank customer
  I want to login successfully

Scenario: Login successfully

  Given I am in the login page of the Para Bank Application
  When I enter valid credentials
  Then I should be taken to the Overview page