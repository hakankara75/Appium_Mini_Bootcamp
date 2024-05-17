
  Feature: Scroll

    Scenario: scroll top of the page
      Given  go to kitapyurdu apk
      And scroll end of the main page
      And scroll top of the page
    @scrollTop_Text
  Scenario: scroll to element text
    Given go to main page
    And click on api demos apk
    And click on views
    And scroll to rotating button


