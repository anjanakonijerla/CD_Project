@test1
Feature: Test facebook smoke scenario
  I want to use this template for my feature file

  @tag2
  Scenario: Test login with valid credentials
   Given Open firefox and start credentials
   When I enter valid "username" and valid "password"
   Then user should be able to login succesfully
   

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

      