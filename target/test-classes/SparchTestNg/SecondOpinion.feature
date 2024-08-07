
@tag
Feature: Second Opinion 

  @tag1
  Scenario: To validate the second opinion functionality
    Given Open browser,enter sparch hospital URL
    And  On the homepage,click on the hospital dropdown
    And  Select the SPARSH Hospital, Yeswanthpur
    When User clicks on Second Opinion link
    And  User enters firstname,lastname, phone, email
    And  Upload the report 
    And  Write a message on the textbox and click on Send button
    Then Thankyou message should be displayed
    And  Bank info should be available in the page

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

      
