package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenueDetailPage {

    private final WebDriver driver;

    //Locators
    @FindBy(xpath = "//button[@ng-click='restaurantCtrl.openRestaurant()']")
    private WebElement btnOpenRestaurant;

    //Constructor
    public VenueDetailPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void openRestaurant() {
        btnOpenRestaurant.click();
    }

}
