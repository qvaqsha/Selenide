package selenide.interpretation;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Hidden;
import com.codeborne.selenide.impl.HasTimeout;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.junit.jupiter.api.Assertions.*;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

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
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1500, 1020));
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
    void inputValues() {
        $("#AuthorIds").click();
        $$(".dx-row").selectOption(4);
        sleep(2000);
    }
}