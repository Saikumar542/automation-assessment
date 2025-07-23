Feature: Verify api Login and Authentication

  Scenario: Successful login
    Given I set login payload with valid credentials
    When I send POST request to login endpoint
    Then I should receive a valid auth token
    
 Scenario: Failed login with invalid credentials
    Given I set login payload with invalid credentials
    When I send POST request to login endpoint
    Then I should receive an authentication error
