@demo1
Feature: Comparison of prices

  #Before Each scenario
  Background: Navigate to TaoBao and verify prices between list page and detials page
    Given I am on Tobao page


  Scenario Outline: Search items
    When I am searching "<items>"
    And I select the 1st item of the results
    Then On the details page I will see the price is equal to previous page

    Examples:
      |items|key|
      |电饭煲|123|
      |微波炉|234|

  @demo1
  Scenario: Search AC
    When I am searching "空调"
    And I select the 1st item of the results
    Then On the details page I will see the price is equal to previous page

