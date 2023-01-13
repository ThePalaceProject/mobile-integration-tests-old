Feature: Localization testing

  @tier3
  Scenario: Spanish: Tutorial and Welcome screen
    When Close tutorial screen
    Then Welcome screen is opened
      And Button Find your library is translated as Encuentra tu biblioteca on welcome screen
    When Close welcome screen
    Then Label Add account is translated as Añadir biblioteca on add account screen
      And Back button is translated as Atrás on add account screen

  @tier3
  Scenario: Spanish: Catalog screen
    When I add "LYRASIS Reads" account from welcomeScreen
    Then Category rows are loaded
      And Label Catalog and More... button are translated on catalog screen

  Scenario: Spanish: Find your library screen
    When I add "LYRASIS Reads" account from welcomeScreen
    Then Category rows are loaded
    When I tap the logo on catalog screen
    Then Find your library screen is opened
      And Find your library label, add library and cancel buttons are translated on find your library screen





#  @tier3
#  Scenario: Italian
#
#
#  @tier3
#  Scenario: German
#
#  @tier3
#  Scenario: French