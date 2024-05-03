
  Feature: Key events
    @spotify
    Scenario: Key events
      Given go to main page
      And click on spotify apk
      And click on Baris Manco
      And click on play
      And volume up
      And volume down
      And back to main page
      And click on Muslum Gurses
      And click on play
      And volume off
      And volume up
      Then stop the music
