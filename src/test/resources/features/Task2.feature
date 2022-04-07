Feature: Task2 feature

  @myTask2

  Background: i am on the page

  Scenario Outline: the thing of adding a person
    When i click add person button using PO
    And i enter name: "<name>" using PO
    And i enter job: "<job>" using PO
    And i click add button using PO
    Then i see "<name>" and "<job>" on the list/page idk
    Examples:
      | name     | job                |
      | Marcella | Creative director  |
      | Ellen    | resident homophobe |

  Scenario Outline: the thing of editing a person
    When i click edit icon using PO
    And i edit "<name>" using PO
    And i edit "<job>" using PO
    And i click edit button using PO
    Then i see "<name>" and "<job>" on the list/page idk
    Examples:
      | name     | job                |
      | Marcella | Creative director  |
      | Ellen    | resident homophobe |

  Scenario Outline: the thing of removing person
    When i click delete icon using PO
    Then person gets removed from this realm using PO

    // lawd have mercy am lost i shall continue tmrw


