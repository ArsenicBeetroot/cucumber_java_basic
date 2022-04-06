Feature: Task1 feature

  @myTask1
  Scenario Outline: schmol
    Given i am on enter a number page
    When i enter a number "<smallNumber>"too small
    And i click submit
    Then i get error message: "Number is too small"
    Examples:  //when i entered 49 as an experiment it actually calculated even tho it shouldnt - thinking emoji.
      | smallNumber |
      | 2 |
      | 48 |
      | 49 |

  Scenario Outline: big
    Given i am on enter a number page
    When i enter a number "<bigNumber>" too big
    And i click submit
    Then i get error message: "Number is too big"
    Examples:
      | bigNumber |
      | 169 |
      | 101 |

  Scenario Outline: text
    Given i am on enter a number page
    When i enter text "<text>"
    And i click submit
    Then i get error message: "Please enter a number"
    Examples:
      | text |
      | a |
      | Supercalifragilisticexpialidocious |

  Scenario Outline: number
    Given i am on enter a number page
    When i enter number "<number>"
    And i click submit
    Then i am god
    Examples:
      | number |
      | 69 |
      | 99 |

