package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class RestaurantPage {

    private final WebDriver driver;

    //Locators
    @FindBy(xpath = "//button[@data-e2e='icon-buttonwalkIn']")
    private WebElement btnWalkIn;

    @FindBy(xpath = "//md-select[@ng-model='bookingNew.tableId']")
    private WebElement lstTable;

    @FindBy(xpath = "//md-tab-item[normalize-space()='Customer Walk In']")
    private WebElement tabCustomerWalkIn;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement txtName;

    @FindBy(xpath = "//md-tab-item[normalize-space()='Notes']")
    private WebElement tabNotes;

    @FindBy(xpath = "//label[text()='Booking Notes']/following-sibling::div/textarea")
    private WebElement txtBookingNotes;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    @FindBy(xpath = "//md-select-value[@class='md-select-value']//div[@class='edit-booking--status-wrap']//p[text()='Seated']")
    private WebElement lblDetailSeatedStatus;

    @FindBy(xpath = "//div[contains(@class, 'BookingOverview')]/textarea[@rows='1']")
    private WebElement txtDetailBookingNotes;


    //Constructor
    public RestaurantPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public boolean isRestaurantPageOpened(String venueName){

        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(titleIs(venueName));

        WebElement venueHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='venue-name' and text()='"+venueName+"']")));
        return venueHeader.isDisplayed();
    }

    public void addNewWalkIn(String table, String customerName, String bookingNote) {
        btnWalkIn.click();
        //Book tab
        lstTable.click();
        WebElement optionTable = this.driver.findElement(By.xpath("//md-option[normalize-space()='"+table+"']"));
        optionTable.click();

        //Customer Walk In tab
        tabCustomerWalkIn.click();
        txtName.clear();
        txtName.sendKeys(customerName);

        //Notes tab
        tabNotes.click();
        txtBookingNotes.clear();
        txtBookingNotes.sendKeys(bookingNote);

        btnSave.click();
    }

    public boolean isBookWalkInConfirmed(String customerName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lblHeadingBooked = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='BOOKED']")));
        if(lblHeadingBooked.isDisplayed()) {
            WebElement lblCustomerName = this.driver.findElement(By.xpath("//div[@class='new-booking--content layout-padding']//booking-info[@class='booking-info']//span[text()='"+customerName+"']"));
            return lblCustomerName.isDisplayed();
        }
        else
            return false;
    }

    public boolean isBookWalkInDetailCorrect(String customerName, String bookingNote){
        WebElement lblCustomerName = this.driver.findElement(By.xpath("//div[@class='new-booking--content layout-padding']//booking-info[@class='booking-info']//span[text()='"+customerName+"']"));
        lblCustomerName.click();

        if(lblDetailSeatedStatus.isDisplayed()) {
            return txtDetailBookingNotes.getText().contains(bookingNote);
        }
        else
            return false;
    }
}
