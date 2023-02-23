Feature: Get Weather forecast

  Scenario: I make a request to API to fetch data

    Given  I make a request to comments Api and Capture the data
    Then I navigate to comments page
    And  I capture the data on UI and validate with API