package selenide.interpretation;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Report {
    private Map<String, Object> vars;
    public String typeId = "4";
    public String organizationId = "3";
    public String authorId = "3";
    public String shortName = "Short name field";
    public String fullName = "Full name field";
    public String summary = "Summary field";

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
        sleep(500);
        $(byXpath("//tr[" + authorId + "]/td[1]")).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();
        sleep(200);
    }

    @Test
    @Order(5)
    void selectType() {
        $("#TypeId").click();
        sleep(100);
        $(".dx-item:nth-child(3)").click();
    }

    @Test
    @Order(6)
    void selectOrganization() {
        $("#executing-organization").click();
        sleep(100);
        String controlContent = $("#ExecutingOrganizationId").getAttribute("aria-controls"); //запись временного id в переменную
        $(byId(controlContent)).find(".dx-item", 3).click(); //поиск нужного в блоке с временным id
    }

    @Test
    @Order(7)
    void inputNumber() {
        $("#InventoryNumber").val("33333");
        $(byName("ShortName")).val(shortName);
        $("#Name").val(fullName);
        $("#Summary").val(summary);
    }

    @Test
    @Order(8)
    void downloadFile() {
        $("#File").scrollIntoView(true);
        $(byName("File")).val("C:\\97KT027.pdf");
    }

    @Test
    @Order(9)
    void submit() {
        $("#submit-form-header-save-btn").click();
        assertEquals(title(), "Сейсмические отчёты");
    }

}