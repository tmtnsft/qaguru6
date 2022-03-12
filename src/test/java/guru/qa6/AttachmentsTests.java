package guru.qa6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AttachmentsTests {
    private static final String REPOSITORY = "tmtnsft/qaguru6";
    AnnoSteps steps = new AnnoSteps();


    @Test
    public void lambdaAttachmentTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
//            Allure.addAttachment("Page source", "text/html", WebDriverRunner.source(), "html ");
            $(partialLinkText("Issueы")).click();
        });
    }

    @Test
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
