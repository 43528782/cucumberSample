@demo
Feature: Comparison of prices

  Scenario: Find DianFanBao on Taobao and verify the pirce
    Given I am on Tobao
    When I put "手机" into the search box
    And I select the 1st result
    Then go to details page I will see the price is as same as the previous page