
  Feature: scroll

    Scenario: scroll down
      Given  go to api demos apk
      And click on views
      And click on splitting touches
      And scroll through 10 elements


    Scenario: scroll up
      Given  go to api demos apk
      And click on views
      And make a page scroll down
      And make a page scroll up

    @scroll
    Scenario: scroll end of the page
      Given  go to kitapyurdu apk
      And scroll end of the page


