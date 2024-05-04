
  Feature: Gesture
@clickGesture
    Scenario: click
      Given go to kitapyurdu apk
      And click on kampanyalar


  Scenario: double click
    Given go to general store apk
    And click on dropdown
    And seleck angola
    And send "deneme" to your name
    And double click on tex
    And click on copy
    @doubleclick
    Scenario: double click on photo
      Given go to photos
      And click on second photo
      And double click on photo

