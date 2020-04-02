Feature: Sample rest API Reqres

  Background: 
    Given user sets the endPoint to "baseURI"

  Scenario Outline: GET Operation to list the page resouces
    When the user wants to get page <page>
    And the user makes a get request to "<location>"
    Then the response should have status code <code>
    And the response should contain "<field>" field as "<value>"
    And show the response

    Examples: 
      | page | location | code | field | value |
      |    2 | endPoint |  200 | page  |     2 |

  Scenario: POST Operation to create a new user
    When the user creates the below data
      | name | job        |
      | indu | trainee qe |
    And the user makes a post request to "endPoint"
    Then the response should have status code 201
    And show the response
