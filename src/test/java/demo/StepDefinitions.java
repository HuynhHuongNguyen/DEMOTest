package demo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LogInPage;
import pages.RestaurantPage;
import pages.VenueDetailPage;
import pages.VenueListPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class StepDefinitions {

    private WebDriver driver = null;
    //Pages
    private LogInPage logInPage = null;
    private VenueListPage venueListPage = null;
    private VenueDetailPage venueDetailPage = null;
    private RestaurantPage restaurantPage = null;

    @Before()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logInPage = new LogInPage(driver);
        venueListPage = new VenueListPage(driver);
        venueDetailPage = new VenueDetailPage(driver);
        restaurantPage = new RestaurantPage(driver);
    }

    @Given("I log in as {string} and {string}")
    public void logInAs(String username, String password) {
        logInPage.logInAs(username, password);
        assertTrue(logInPage.isLogInSuccessful());
    }

    @When("I select to open {string}")
    public void selectOption(String option) {
//        logInPage.selectOption(option);
    }

    @When("I click to open venue {string} and open restaurant")
    public void openVenueAndRestaurant(String venueName) {
//        venueListPage.openVenue(venueName);
//        venueDetailPage.openRestaurant();
//        assertTrue(restaurantPage.isRestaurantPageOpened(venueName));
    }

    @When("I click to add a new walk in at table {string} for customer {string} with note {string}")
    public void addNewWalkIn(String table, String customerName, String bookingNote) {
//        restaurantPage.addNewWalkIn(table, customerName, bookingNote);
    }

    @Then("A Walk-in is booked successfully for customer {string}")
    public void verifyBookingWalkInConfirmed(String customerName) {
//        assertTrue(restaurantPage.isBookWalkInConfirmed(customerName));
    }

    @Then("Detail of the Walk-in booking is correct for customer {string} with note {string}")
    public void verifyBookingWalkInDetailCorrect(String customerName, String bookingNote) {
//        assertTrue(restaurantPage.isBookWalkInDetailCorrect(customerName, bookingNote));
    }

    @After()
    public void teardown() {
        //driver.quit();
    }

}
