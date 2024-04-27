
  Feature: Toast Message and Hide Keyboard
    @toastMessageN
    Scenario: Toast Message
      Given go to n11 apk
      And click on n11 hesabim
      And click on n11 hesabim giris yap
      And send email to n11 email box
      And click on n11 hesabim giris yap second
      And send to n11 sifre box
      When click on n11 hesabim giris yap third
      Then verify error message

      @toastMessageBlabla
      Scenario: Blabla
        Given go to blabla
        And click on blabla giris yap first
        And click on eposta
        And send eposta
        And send parola
        When click on giris yap
        Then verify blablas error message
