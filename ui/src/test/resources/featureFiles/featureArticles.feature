Feature: Test article and post

  @smoke-selenide @TC-1-selenide
  Scenario: Select article and check the post counters
    Given I am open articles page
      When I am open article 8
      And I am check post title
      Then I am assert votes count