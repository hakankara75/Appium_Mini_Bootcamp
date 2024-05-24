
  Feature: Swipe
@swipeLeft
    Scenario: Swipe with coordinates
      Given go to kitapyurdu apk
      And swipe to left
@swipeTop
  Scenario: swipe with main page
    Given go to kitapyurdu apk
    And swipe to top
@swipeElement
    Scenario: swipe with element
      Given go to kitapyurdu apk
      And swipe with element

    Scenario: fling to down
      Given go to kitapyurdu apk
      And fling down
    @fling
    Scenario: fling to left
      Given go to kitapyurdu apk
      And fling left


