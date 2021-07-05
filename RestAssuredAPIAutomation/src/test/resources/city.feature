Feature: Details of the cities
  Description: To get the details of the cities

  Scenario Outline: Verify the details of the given city
    Given The URL for the list of companies and its location in the network
    When Hit the URL with the  "<Citypathparam>" path param
    Then Verify the "<City>" City is in the "<Country>" Country
    And Verify the "<Latitude>" and "<Longitude>" of the city

    Examples: 
      | Citypathparam   | City      | Country | Latitude | Longitude |
      | /visa-frankfurt | Frankfurt | DE      |  50.1072 |   8.66375 |
