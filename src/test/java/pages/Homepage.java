package pages;

import hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Hooks.getDriver(),this);
    }

    @FindBy(name ="q")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='record-count text-right mt-3 mb-3']")
    public WebElement searchResult;

}
