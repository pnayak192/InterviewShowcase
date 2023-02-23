Feature: Validate all Users List
  Scenario: Validate the response of Users List with UI
    Given  I capture the response from Users API
    When   I navigate to Users page
    Then   I compare the API data with UI data