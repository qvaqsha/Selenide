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
class Interpretation {
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
    void goToIp() {
        $(".col-2:nth-child(6) .position-absolute").click();
    }

    @Test//Создаём Проект
    @Order(3)
    void interpretationCreate() {
        $("#create-ip-btn .dx-button-text").click();
        $("#Name").click();
        $("#Name").val("Selenium");
        $("#DatumLevel").click();
        $("#DatumLevel").val("123");
        $("#ReportId > .dx-dropdowneditor-input-wrapper .dx-button-content").click();
        $(byXpath("//td[@aria-describedby=\'dx-col-1\']")).doubleClick();
        $("#BackupMethodId").click();
        $(byText("Отсутствует")).click();
        $("#certificate .dx-texteditor-input").click();
        sleep(400);
        $(byText("Родитель")).doubleClick();
        sleep(200);
        $(".dx-texteditor-input-container > #InterpretationSystemId").click();
        sleep(900);
        $(byText("GeoCluster-3100")).doubleClick();
        sleep(500);
        $("#ProjectionId").click();
        sleep(500);
        $(byText("Lambert")).click();
        sleep(500);
        $("#Comment").click();
        sleep(500);
        $("#Comment").val("IDE selenium");
        sleep(500);
        $("#submit-form-header-save-btn .dx-button-text").click();
        assertEquals(title(), "Интерпретационные данные");
    }

    @Test
    @Order(4)
//Добавление Корреляции
    public void correlation() {
        $(byXpath("//span[contains(text(),\'Данные интерпретационного проекта\')]")).click();
        $(byXpath("//div[@class=\'dx-datagrid-header-panel\']//span[text()=\'Создать\']")).click();
        $(byXpath("//div[@title=\'Текстовый файл\']")).click();
        $("#File").val("C:\\Art.txt");
        sleep(500);
        $(".dx-texteditor-container:nth-child(2) .dx-texteditor-input").click();
        $(byXpath("//div[contains(text(),\'T0 (корреляция ОГ)\')]")).click();
        $(byXpath("//textarea")).val("Корреляция selenium IDE");
        sleep(2000);
        $("#wizard__next-button .dx-button-text").click();
        sleep(1000);
        $("#wizard__next-button .dx-button-text").click();
        sleep(1000);
        $("#wizard__skip-button .dx-button-text").click();
        sleep(1000);
        $("#template-configuration__select-box .dx-texteditor-input").click();
        $(byXpath("//div[text()=\'Данные T0 по сейсмическим разрезам 2D\']")).click();
        sleep(900);
        $("#wizard__next-button .dx-button-text").click();
        $("#wizard-mapping-data-grid-container-drop-down-button-0 .dx-dropdowneditor-icon").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Наименование профиля / Съёмки 3D\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-1 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Пункт ОГТ\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-2 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'X\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-3 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Y\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-4 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Наименование горизонта\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-5 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Значение Т0\')] ")).click();
        sleep(2000);
        $("#wizard__next-button .dx-button-text").click();
        sleep(2000);
        $("#wizard__next-button .dx-button-text").click();
        $("#survey-column-select-box .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Наименование профиля / Съёмки 3D\')] ")).click();
        $(".dx-icon-more").click();
        sleep(600);
        $(byXpath("//tr[@aria-level=\'1\' and @aria-rowindex=\'5\']//div[@role=\'checkbox\']")).click();
        sleep(500);
        $(byXpath("//span[text()=\'Выбрать\']")).click();
        $(".dx-data-row > .border-left-0").click();
        $(".dx-data-row > .border-left-0").doubleClick();
        $("#wizard__next-button .dx-button-text").click();
        sleep(1000);
        $("#wizard__next-button .dx-button-text").click();
    }

    @Test
    @Order(5)
//Добавляем бинарник в данные ип
    public void binFile() {
        $(byXpath("//div[@class=\'dx-datagrid-header-panel\']//span[text()=\'Создать\']")).click();
        $(byXpath("//div[@title=\'Бинарный файл\']")).click();
        $("#File").val("C:\\97KT027.pdf");
        $(".dx-texteditor-container:nth-child(2) .dx-texteditor-input").click();
        $(byXpath("//div[contains(text(),\'Разломы\')]")).click();
        $(byXpath("//textarea")).val("Бинарник selenium IDE");
        sleep(200);
        $(byText("Сохранить")).click();
        sleep(500);
    }

    @Test
    @Order(6)
//Добавление данных гео модели
    public void grid() {
        String idip = $(".dx-row-focused").$(byAttribute("aria-describedby", "dx-col-1")).text();
        System.out.println(idip);
        $(byText("Главная")).click();
        $(".col-2:nth-child(6) .position-absolute").click();
        $(byXpath("//*[@id=\"interpretation-project-id\"]/div/div[4]/div/div/div[1]/div[2]/div/div")).click();
        $(byXpath("//*[@id=\"interpretation-project-id\"]/div/div[4]/div/div/div[1]/div[2]/div/div/div/div[1]/input")).val(idip);
        $(byText(idip)).click();
        $(byText("Данные геологической модели")).click();
        $("#add-ip-file-btn").click();
        $(byText("Текстовый файл")).click();
        $("#File").val("C:\\Art.txt");
        $(byXpath("//textarea")).val("Текстовый файл (Гриды)");
        sleep(300);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(200);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(200);
        $("#wizard__skip-button .dx-button-text").click();
        sleep(200);
        $("#wizard-mapping-data-grid-container-drop-down-button-4 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Значение параметра\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-3 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'X\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-2 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Y\')] ")).click();
        sleep(500);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(500);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(500);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(6000);
        assertEquals(title(), "Интерпретационные данные");
    }

    @Test
    @Order(7)
//Добавление Zmap файла
    public void zmapCreate() {
        $(byXpath("//*[@id=\"add-ip-file-btn\"]/div/div/div/div/span")).click();
        $(byAttribute("title", "Файл Zmap")).click();
        $("#File").val("C:\\07_045_Id.zmap");
        sleep(5000);
        $(byXpath("//textarea")).val("Zmap");
        $("#wizard__next-button > .dx-button-content").click();
        sleep(3000);
        $(byText("Нет")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-0 .dx-texteditor-input").click();
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'X\')] ")).click();
        sleep(1500);
        $("#wizard-mapping-data-grid-container-drop-down-button-1 .dx-texteditor-input").click();
        sleep(1500);
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Y\')] ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-2 .dx-texteditor-input").click();
        sleep(1500);
        $(byXpath("//div[@class=\'dx-overlay-content dx-popup-normal dx-resizable\']//div[@class=\'dx-item-content dx-list-item-content\' and contains(text(),\'Значение параметра\')] ")).click();
        sleep(2000);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(15000);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(6000);
        $("#wizard__next-button > .dx-button-content").click();
        sleep(8000);
        assertEquals(title(), "Интерпретационные данные");
    }

    @Test
    @Order(8)
//Добавление бинарника в данные геомодели
    public void binCreate() {
        $(byXpath("//div[@class=\'dx-datagrid-header-panel\']//span[text()=\'Создать\']")).click();
        $(byXpath("//div[@title=\'Бинарный файл\']")).click();
        $("#File").val("C:\\97KT027.pdf");
        sleep(2000);
        $(byXpath("//textarea")).val("Бинарник selenium IDE");
        sleep(200);
        $(byXpath("//span[text()=\'Сохранить\']")).click();
        sleep(2500);
        assertEquals(title(), "Интерпретационные данные");
    }
}
