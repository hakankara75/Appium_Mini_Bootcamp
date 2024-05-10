
  Feature: Long click Dragdrop
@longclick
    Scenario: Long click
      Given go to main page
      When long click on spotify apk
      Then verify "Search" text
@dragdrop
Scenario: dragdrop
  Given go to api demos apk
  And click on views
  And click on drag and drop
  And drag and drop





