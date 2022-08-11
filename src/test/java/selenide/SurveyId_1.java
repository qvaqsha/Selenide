package selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyId_1 {

    void l2DSurveyCreate() {
        $("#surveyType").click();
        $(byText("Наземная 2D")).click();
        $(byText("Поиск")).click();

        $(byText("Добавить съёмку")).click();
        $("#Name").val("Autotest");
        $("#ExpeditionOrganizationId").click();
        String oId = $("#ExpeditionOrganizationId").getAttribute("aria-owns");
        $(byId(oId)).$(".dx-item:nth-child(4)").click();

        $("#WorkMethodId").click();
        String mId = $("#WorkMethodId").getAttribute("aria-owns");
        $(byId(mId)).$(".dx-item:nth-child(4)").click();

        $("#WorkStatusId").click();
        $("#WorkStatusId-datagrid").$(".dx-row:nth-child(4)").doubleClick();

        $("#WorldRegionId").click();
        String wId = $("#WorldRegionId").getAttribute("aria-owns");
        $(byId(wId)).$(".dx-item:nth-child(7)").click();

        $("#ExecutingOrganizationId").click();
        String EOId = $("#ExecutingOrganizationId").getAttribute("aria-owns");
        $(byId(EOId)).$(".dx-item:nth-child(15)").scrollIntoView(true).click();

        $("#SubjectId").click();
        $("#subject-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(10)").doubleClick();

        $("#WorkVolume").val("34562");
        $("#StartDate").val("2022");
        $("#EndDate").val("2022");
        $("#Comment").val("selenide test");

        $("#devextreme21").click();
        sleep(500);
        $$(".dx-datagrid-content").get(7).$$(".dx-checkbox").get(5).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $(byText("Сохранить")).click();
        assertEquals(title(), "Методика полевых работ");
        sleep(2000);
    }

    void l2dSampleCreate() {
        $(byText("Добавить профиль")).click();
        $("#Name").val("01223525");

        $("#topology_coordinates_source").click();
        $("#topology_coordinates_source-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row.nth:child(3)").doubleClick();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $(byText("Далее")).click();
        $("#source_type").click();
        $("#source_type-datagrid").$$("#dx-datagrid-table").get(1).$(".dx-row:nth-child(16)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#sweep_signal_type").click();
        $("#sweep_signal_type-datagrid").$$("#dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#begin_sweep_signal_frequency").val("30");
        $("#avg_explosive_weight").val("0.33");

        $("#acquisition_method").click();
        $("#acquisition_method-datagrid").$$("#dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        
    }

}
