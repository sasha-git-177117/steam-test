package pages;

import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'home_page_col_wrapper')]");
    private final NavBarTop navBar = new NavBarTop();
    private final NavBarStore navBarStore = new NavBarStore();
    public MainPage() {
        super(CHECK_ELEMENT, "checkElementMainPage");
    }
}
