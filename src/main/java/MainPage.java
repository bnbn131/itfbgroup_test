import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static WebDriver driver;
    private WebDriverWait wait;



    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void openLinck(){
        driver.get("https://market.yandex.ru");
    }


    @FindBy (xpath = "//div[@class='n-w-tab__control b-zone b-spy-events i-bem n-w-tab__control_js_inited']//span")
    private WebElement catalog;


    @FindBy (linkText = "Лакомства")
    private WebElement delicacy;

    @FindBy (css = "#glpricefrom")
    private WebElement paramMin;

    @FindBy(css = "#glpriceto")
    private WebElement paramMax;

    @FindBy (xpath = "//fieldset[@class='_2qWuY12N6f']//li[1]//div[1]//label[1]//div[1]")
    private WebElement delivery;

    @FindBy (linkText = "Все фильтры")
    private WebElement filter;

    @FindBy (xpath = "//label[contains(text(),'Whiskas')]")
    private WebElement whiskas;

    @FindBy (linkText = "Показать подходящие")
    private WebElement showAll;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]") //Данный xpath должен работать, даже если товар изменится. (ПОнимаю, так желательно не делать)
    private WebElement firstElement;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]") // по другому не смог кликнуть на "Сравнение"
    private WebElement compare;

    @FindBy (xpath = "//label[contains(text(),'Мнямс')]")
    private WebElement mniams;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/a[1]/img[1]")
    private WebElement secondElement;

    @FindBy (xpath = "//a[@class='button button_size_m button_theme_normal i-bem button_js_inited']")
    private WebElement comparison;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[5]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]")
    private WebElement delWhiskas;

    @FindBy (xpath = "//span[@class='n-compare-toolbar__action-clear link']//span[@class='link__inner']")
    private WebElement fullDel;

    @FindBy (xpath = "//div[@class='title title_size_18']")
    private WebElement noItem;

    public void setNoItem() {
        noItem.isDisplayed();
    }

    public void setFullDel() {
        fullDel.click();
    }

    public void setDelWhiskas() {
        delWhiskas.click();
    }

    public void setComparison() {
        comparison.click();
    }

    public void setSecondElement() {
        secondElement.click();
    }

    public void setMniams() {
        mniams.click();
    }

    public void setCompare() {
        compare.click();
    }

    public void setFirstElement() {
       firstElement.click();
    }

    public void setShowAll() {
        showAll.click();
    }

    public void setWhiskas() {
        whiskas.click();
    }

    public void setFilter() {
       filter.click();
    }

    public void setDelivery() {
        delivery.click();
    }

    public void setParamMax() {
        paramMax.sendKeys("150");
    }

    public void setParamMin() {
       paramMin.sendKeys("50");
    }

    public void setDelicacy(){
        delicacy.click();
    }


    public void setCatalog() {
        catalog.click();
    }

    public void petProduct(){
        WebElement element = driver.findElement(By.linkText("Товары для животных"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


}
