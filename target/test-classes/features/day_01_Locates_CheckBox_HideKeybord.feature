Feature: Api Demos
    @kitapyurdu
    Scenario: kitapyurdu
      Given go to kitapyurdu apk
      When click on ilgi gorenler

@apiDemos
Scenario: api demos
  Given go to api demos apk
  Then verify api demos text appears
  When click on accessibility link
  Then assert accesibility page open

@n11
Scenario: n11
  Given go to n11 apk
  Then assert n11 page
  And click on n11 searchbox
  And send "kazak" to n11 searchbox
  And select "erkek kazak"
  And click filtrele
  And click beden
  When click M checkbox
  Then assert M checkbox checked