package guru.qa6;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsTest {

    private static final String REPOSITORY = "tmtnsft/qaguru6";
    AnnoSteps steps = new AnnoSteps();

    @Test
    public void lambdaStepsTest() {
        Allure.label("owner", "tmtnsft");
        Allure.feature("Issues");
        Allure.story("Поиск таба Issues в профиле. Негативный сценарий");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.parameter("QAGuru", "Github");

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issueы", () -> {
            //Allure.addAttachment("Page source", "text/html", WebDriverRunner.source(), "html ");
            $(partialLinkText("Issueы")).click();
        });
    }

    @Test
    @Owner("tmtnsft")
    @Feature("Issues")
    @Story("Поиск таба Issues в профиле. Позитивный сценарий")
    @DisplayName("Поиск таба Issues. Позитивный сценарий")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    public void annotatedStepsTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
    }

    @AfterEach
    public void saveSources() {
        steps.attachPageSource();
    }
}
