Feature: Conduit App Test
Scenario: Login into App
    Given User is on Login page
    When User provide "rekha.s.2906@gmail.com" and "Test@123"
    Then User should be on Home Page
  Scenario: Create new Article
    Given User should be on New Article Page
    When User enters Article details
      | title        | Desc        | Content      | tag     |
      | Sample Title 1 | Description | Article body | testTag |
    Then Article must be created

  Scenario: Update an Article
    Given Article detail page must be displayed
    When User update article detail
    Then Article detail must be updated

  Scenario: Delete an Article
    Given Article detail page must be displayed
    When User delete article
    Then Article must be deleted
