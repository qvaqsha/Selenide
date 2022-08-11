package selenide;

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
    public String login = "sovkovve";
    public String pass = "SOVKOVVE";
    public int typeId = 4;
    public int organizationId = 3;
    public String authorId = "3";
    public String shortName = "Short name field";
    public String fullName = "Full name field";
    public String summary = "Summary field";
    public String InventoryNumber = "3341123";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        vars = new HashMap<>();
    }

    @Test
    @Order(1)
        //Авторизация
    void authorization() {
        Login login = new Login();
        login.authorization(1);
        $(byTitle("Домашняя страница")).shouldBe(visible);
    }

    @Test
    @Order(2)
        //Вход в сейсмические отчёты
    void goToReport() {
        $(byAttribute("href", "/Report")).click();
    }

    @Test
    @Order(3)
    void reportCreate() {
        $(byText("Создать")).click();
    }

    @Test
    @Order(4)
        //Выбор автора отчёта
    void inputAuthor() {
        $("#AuthorIds").click();
        sleep(500);
        $(byXpath("//tr[" + authorId + "]/td[1]")).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();
        sleep(200);
    }

    @Test
    @Order(5)
        //Выбор типа отчёта
    void selectType() {
        $("#TypeId").click();
        sleep(100);
        $(".dx-item:nth-child(" + typeId + ")").click();
    }

    @Test
    @Order(6)
        //Выбор организации
    void selectOrganization() {
        $("#executing-organization").click();
        sleep(100);
        String controlContent = $("#ExecutingOrganizationId").getAttribute("aria-controls"); //запись временного id в переменную
        $(byId(controlContent)).find(".dx-item", organizationId).click(); //поиск нужного в блоке с временным id
    }

    @Test
    @Order(7)
        //Заполнение полей наименования и реферата
    void inputNumber() {
        $("#InventoryNumber").val(InventoryNumber);
        $(byName("ShortName")).val(shortName);
        $("#Name").val(fullName);
        $("#Summary").val(summary);
    }

    @Test
    @Order(8)
        //Загрузка файла
    void downloadFile() {
        $("#File").scrollIntoView(true);
        $(byName("File")).val("C:\\97KT027.pdf");
    }

    @Test
    @Order(9)
        //Сохранение и проверка редиректа на страницу сейсм отчёты
    void submit() {
        $("#submit-form-header-save-btn").click();
        assertEquals(title(), "Сейсмические отчёты");
    }
}