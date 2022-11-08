Feature: Booking

  Scenario Outline: Booking a Walk-in
    Given I log in as "<username>" and "<password>"
    When  I select to open "<option>"
    And   I click to open venue "<venue_name>" and open restaurant
    And   I click to add a new walk in at table "<table>" for customer "<customer_name>" with note "<booking_note>"
    Then  A Walk-in is booked successfully for customer "<customer_name>"
    Then  Detail of the Walk-in booking is correct for customer "<customer_name>" with note "<booking_note>"

  Examples:
    | username | password          | option       | venue_name    | table            | customer_name | booking_note |
    | tutorial | tutorial | Admin Portal | My Pizza Shop | T1 * C21 outside | Joes          | testing      |
