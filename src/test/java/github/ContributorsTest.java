package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    @Test
    void solntsevShouldBeFirstContributor(){
        //open repository page
        Configuration.browserSize ="800x400";
        open("https://github.com/selenide/selenide");
        //bring mouse over the first avatar tab
        //check popup is showing Andrei Solntsev
        $(".Layout-sidebar").$$("h2").filterBy(text("Contributors"))
                .first()
                .sibling(0).$$("li").first().hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
