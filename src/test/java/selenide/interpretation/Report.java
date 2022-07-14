package selenide.interpretation;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Report {
    private Map<String, Object> vars;


    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        vars = new HashMap<>();
    }

    @Test
    @Order(1)
//Авторизация
    void authorization() {
        open("https://rn-sdc.dmdevelopment.ru//Account/Login?ReturnUrl=%2F");
//        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1500, 1020));
        $(byName("Login")).val("sovkovve");
        $(byName("Password")).val("SOVKOVVE");
        $(".dx-button-text").click();
    }

    @Test
    @Order(2)
//Вход в Интерпретационные проекты
    void goToReport() {
        $(".col-2:nth-child(1) .position-absolute").click();
    }

    @Test
    @Order(3)
    void reportCreate() {
        $(byText("Создать")).click();
    }

    @Test
    @Order(4)
    void inputAuthor() {
        $("#AuthorIds").click();
        $(byXpath("//tr[3]/td[1]")).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();
        sleep(2000);
    }
}