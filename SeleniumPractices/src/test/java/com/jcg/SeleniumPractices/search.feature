Feature: Search


  Scenario: Successful Search
    Given I open chrome browser
    When I navigate to google search page
    And I provide search text as selenium and enter
    Then Selenium should be in page title


  Scenario Outline: Successful Search
    Given I open chrome browser
    When I navigate to google search page
    And I provide search text as "<searchTerm>" and enter
    Then "<searchTerm>" should be in page title

    Examples:
      | searchTerm |
      | Selenium |
      | Cucumber |

  Scenario Outline: Successful Search
    Given I open "<browser>" browser
    When I navigate to google search page
    And I provide search text as "<searchTerm>" and enter
    Then "<searchTerm>" should be in page title

    Examples:
      | searchTerm|browser  |
      | Selenium  |chrome   |
      | Cucumber  |chrome   |
      | Selenium  |firefox  |

