@Smoke
Feature: I want to create a user
  Scenario Outline: I will pass user details by DataTable to create a user
    Given I provide user details by DataTable
      |name|job|
      | <name>   | <job>  |
    When  I make a request to users API using POJO
    Then  I should find the user created
    Examples:
      |name|job|
      | Eli    | programer1  |
      |  Elton  | programer2   |

  Scenario Outline: I will pass user details by Json to create a user
    Given I provide user details by Json present in "<PayloadFileName>"
    When  I make a request to users API using JsonPayload
    Then  I verify the Schema of the response with "<ResponseSchemaFileName>"
    Examples:
      | PayloadFileName |  ResponseSchemaFileName  |
      |  payload1.json  |   response1Schema.json   |