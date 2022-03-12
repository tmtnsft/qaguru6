package guru.qa6;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
         open("https://github.com");
        $(".header-search-input").setValue("tmtnsft/qaguru6").pressEnter();
        $(linkText("tmtnsft/qaguru6")).click();
        $(partialLinkText("Issues")).click();
        $("#issues-tab").shouldBe(Condition.visible);
    }
}
