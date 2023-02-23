Feature: Add to cart

  @smoke
  Scenario Outline: Add one quantity from Store
    Given I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |
      | Anchor Bracelet |


#  @smoke
#  Scenario Outline: Add one quantity from Store
#    Given I'm on the UKHome Page
#    And I navigate to Search Page
#    When I search "<product_name2>"
#    Then I should see "<product_name2>" in the result
#    Examples:
#      | product_name2 |
#      | Visa  |