Feature: public weather API

  @SmokeTest
  Scenario Outline: API request by latitude and longitude should return closest office "forecast property" location
    Given I send GET request with given "<latitude>" and "<longitude>"
    Then I should get "200" status code
    And Response body should contain "<closest forecast property>"
    And Response time should be not more than "1000" ms

    Examples:
    |latitude  | longitude  | closest forecast property |
    | 39.952583|-75.165222  | PHI                       |
    | 47.751076|-120.740135 | OTX                       |
    | 26.12231 | -80.14338  | MFL                       |
    | 33.448376| -112.074036| PSR                       |