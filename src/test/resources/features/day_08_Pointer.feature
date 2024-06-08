Feature: pointer tap
  @pointer
  Scenario: pointer
    Given go to kitapyurdu apk
    And tap on the second book
@pointerdoubletap
Scenario: double tap
  Given go to kitapyurdu apk
  And double tap on first book in ilgi gorenler
@pointerlongclick
Scenario: double tap
  Given go to kitapyurdu apk
  And long click on sepetim
  @pointerswipeleft
  Scenario: double tap
    Given go to kitapyurdu apk
    And swipe to left first book of ilgi gorenler
@pointerfling
Scenario: double tap
  Given go to kitapyurdu apk
  And fling left first book of ilgi gorenler
@pointerDragDrop
Scenario: drag drop
  Given go to api demos apk
  And click on views
  And click on drag and drop
  And drag and drop with pointer
@pointerZoomInZoomOut
Scenario: zoom in zoom out
  Given go to files
  And click on first screen
  And pointer zoom in
  And pointer zoom out



