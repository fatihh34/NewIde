
@go_the_website
Feature:Go to Website and Check Buttons and Links

  Scenario: Go the website
    When user goes the page
    Then user search "ürün" in searchbox
    Then user validate that there is no product