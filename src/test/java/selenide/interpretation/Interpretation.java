package selenide.interpretation;

import com.codeborne.selenide.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;


import org.openqa.selenium.Dimension;


import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Interpretation {
    private Map<String, Object> vars;
    public String login = "sovkovve";
    public String pass = "SOVKOVVE";
    String projectName = "Selenide";
    String datumLevel = "33";
    int reportNum = 1;
    int certificateNum = 1;
    int projectionNum = 0;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        vars = new HashMap<>();
    }

    @Test
    @Order(1)
//Авторизация

    public void authorization() {
        open("https://rn-sdc-newdb.dmdevelopment.ru//Account/Login?ReturnUrl=%2F");
        $(byName("Login")).val(login);
        $(byName("Password")).val(pass);
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
        $("#Name").val(projectName);
        $("#DatumLevel").val(datumLevel);
        $("#ReportId > .dx-dropdowneditor-input-wrapper .dx-button-content").click();
        sleep(600);

        $("#ReportId-datagrid").find("tr", reportNum).scrollIntoView(true).doubleClick();
        $("#BackupMethodId").click();
        $(byText("Отсутствует")).click();

        $("#certificate .dx-texteditor-input").click();
        sleep(400);
        $(".dx-datagrid-table ", 5).find("td", certificateNum).scrollIntoView(true).doubleClick();
//        $(byText("Родитель")).doubleClick();
        sleep(200);

        $(".dx-texteditor-input-container > #InterpretationSystemId").click();
        sleep(900);
        $(".dx-datagrid-table ", 5).find("td", certificateNum).scrollIntoView(true).doubleClick();
//        $(byText("GeoCluster-3100")).doubleClick();
        sleep(500);

        $("#ProjectionId").click();
        sleep(500);
        String projectionId = $("#ProjectionId").getAttribute("aria-controls");
        $(byId(projectionId)).find(".dx-item", projectionNum).click();
//        $(byText("Lambert")).click();
        sleep(500);
//        $("#Comment").click();

        $("#Comment").val("IDE selenium");
        sleep(500);
        $(byText("Сохранить")).click();
        assertEquals(title(), "Интерпретационные данные");
    }

    @Test
    @Order(4)
//Добавление Корреляции
    public void correlation() {
        $(byText("Данные интерпретационного проекта")).click();
        String tab = $(".dx-tabpanel > .dx-tabpanel-tabs .dx-tabs .dx-tab.dx-tab-selected").getAttribute("aria-controls");
        System.out.println(tab);
        $(byId(tab)).find("#add-ip-file-btn").click();
        $(byText("Текстовый файл")).click();
        $("#File").val("C:\\Art.txt");
        sleep(500);
        $(".dx-texteditor-container:nth-child(2) .dx-texteditor-input").click();
        $(byText("T0 (корреляция ОГ)")).click();
        $("#ip-file-description-text-area").val("Корреляция selenium IDE");
        sleep(2000);
        $(byText("Далее")).click();
        sleep(1000);
        $(byText("Далее")).click();
        sleep(1000);
        $(byText("Пропустить")).click();
        sleep(1000);
        $("#template-configuration__select-box .dx-texteditor-input").click();
        $(byText("Данные T0 по сейсмическим разрезам 2D")).click();
        sleep(900);
        $(byText("Далее")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-0").click();
        $(byText("Наименование профиля / Съёмки 3D")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-1").click();
        $(byText("Пункт ОГТ")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-2").click();
        $(byText("X")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-3").click();
        $(byText("Y")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-4").click();
        $(byText("Наименование горизонта")).click();
        $("#wizard-mapping-data-grid-container-drop-down-button-5").click();
        $(byText("Значение Т0")).click();
        sleep(2000);
        $(byText("Далее")).click();
        sleep(2000);
        $(byText("Далее")).click();
        $("#survey-column-select-box .dx-texteditor-input").click();
        $(byText("Наименование профиля / Съёмки 3D")).click();
        $(".dx-icon-more").click();
        sleep(600);
        $(byXpath("//tr[@aria-rowindex=\'5\']//div[@role=\'checkbox\']")).click();
        sleep(500);
        $(byText("Выбрать")).click();
        $(".dx-data-row > .border-left-0").click();
        $(".dx-data-row > .border-left-0").doubleClick();
        $(byText("Далее")).click();
        sleep(1000);
        $(byText("Сохранить")).click();
    }

    @Test
    @Order(5)

//Добавляем бинарник в данные ип
    public void binFile() {
        $(byXpath("//span[contains(text(),\'Данные интерпретационного проекта\')]")).click();
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
//        String idip = $(".dx-row-focused").$(byAttribute("aria-describedby", "dx-col-1")).text();
//        System.out.println(idip);
//        $(byText("Главная")).click();
//        $(".col-2:nth-child(6) .position-absolute").click();
//        $("#ExecutingOrganizationId").getAttribute("aria-controls");
        $(byText("Данные геологической модели")).click();
        String tab = $(".dx-tabpanel > .dx-tabpanel-tabs .dx-tabs .dx-tab.dx-tab-selected").getAttribute("aria-controls");
        System.out.println(tab);
        $(byId(tab)).find("#add-ip-file-btn").click();
//        $(byXpath("//*[@id=\"interpretation-project-id\"]/div/div[4]/div/div/div[1]/div[2]/div/div")).click();
//        $(byXpath("//*[@id=\"interpretation-project-id\"]/div/div[4]/div/div/div[1]/div[2]/div/div/div/div[1]/input")).val(idip);
//        $(byText(idip)).click();
//        $(byText("Данные геологической модели")).click();
//        $("#add-ip-file-btn").click();
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

    @Test
    @Order(9)
    public void delete() {
        $("#interpretation-project-grid").find(".dx-texteditor-input").val("Selenium");
        sleep(1500);
        while (!$(byText("Нет данных")).exists()) {
            $("#interpretation-project-id").find(".dx-datagrid-table", 1).find(".dx-command-edit").find(".dx-item").click();
            sleep(800);
            $(byText("Удалить")).click();
            sleep(800);
            $(byText("Да")).click();
            sleep(500);
        }
    }
}
