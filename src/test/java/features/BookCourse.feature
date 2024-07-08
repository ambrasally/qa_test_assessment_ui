Feature: Test different actions on landing page

  @smoke
  Scenario Outline: As a user I want open the Cloud Academy page and look for different courses
    Given I navigate to Cloud Academy to search for <courseName> course
    When I go to the pricing plans to select one
    Then I should see the Sign Up Form

    Examples:
      | courseName |
      | AWS        |
      | GCP        |
      | Azure      |
