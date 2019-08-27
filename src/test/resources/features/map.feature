@tag
Feature: provide details using single dimensional map
  I want to use this template for my feature file

  @tag1
  Scenario: providing datausing map
    Given User should launch browser
    And  user click add customer link
    When  user provide valid details
   
     |fname  | ram | 
      |lname | sam | 
      | gmail | samathapanjala21@gmail.com     |
    |address|telangana|
    |phoneno|9642752712|
    Then To verify the customer id is displayed

 