package guru.qa6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue("tmtnsft/qaguru6").pressEnter();
        $(linkText("tmtnsft/qaguru6")).click();
        $(partialLinkText("Issueы")).click();
        $("#issues-tab").shouldBe(Condition.visible);
    }
}
