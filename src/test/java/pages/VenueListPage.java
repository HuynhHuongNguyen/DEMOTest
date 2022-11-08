package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VenueListPage {

    private final WebDriver driver;

    //Locators

    //Constructor
    public VenueListPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public WebElement getElementVenue(String venueName) {
        return this.driver.findElement(By.xpath("//td[@class='ng-binding' and text()='"+venueName+"']"));
    }

    public void openVenue(String venueName) {
        WebElement lnkVenue = getElementVenue(venueName);
        lnkVenue.click();
    }

}
