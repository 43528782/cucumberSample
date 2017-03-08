@demo1
Feature: Comparison of prices

  Background: Navigate to TaoBao and verify prices between list page and detials page
    Given I am on Tobao page

  Scenario Outline: Search items
    When I am searching "<items>"
    And I select the 1st item of the results
    Then On the details page I will see the price is equal to previous page

    Examples:
    |items|
    |电饭煲|
    |微波炉|