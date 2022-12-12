package selenide;

import org.apache.commons.lang3.RandomStringUtils;

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
        $("#"+ $("#ExpeditionOrganizationId").getAttribute("aria-owns")).$(".dx-item:nth-child(4)").click();

        $("#WorkMethodId").click();
        String mId = $("#WorkMethodId").getAttribute("aria-owns");
        $(byId(mId)).$(".dx-item:nth-child(4)").click();

        $("#WorkStatusId").click();
        sleep(500);
        $("#WorkStatusId-datagrid").$(".dx-row:nth-child(4)").doubleClick();

        $("#WorldRegionId").click();
        String wId = $("#WorldRegionId").getAttribute("aria-owns");
        $(byId(wId)).$(".dx-item:nth-child(7)").click();

        $("#ExecutingOrganizationId").click();
        String EOId = $("#ExecutingOrganizationId").getAttribute("aria-owns");
        $(byId(EOId)).$(".dx-item:nth-child(15)").scrollIntoView(true).click();

        $("#SubjectId").click();
        sleep(500);
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
        if($(".dx-show-invalid-badge").exists()) {
            String generatedString = RandomStringUtils.randomAlphabetic(3);
            $("#Name").val("Autotest_" + generatedString);
            sleep(150);
            $(byText("Сохранить")).click();
            sleep(300);
        };
        assertEquals(title(), "Методика полевых работ");
        sleep(2000);
    }

   public void l2dSampleCreate(int count) {

      /*  На случай тестов без создания съёмки
        $("#surveyType").click();
        $(byText("Наземная 2D")).click();
        $(byText("Поиск")).click();
        $("#survey-grid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(16)").scrollIntoView(true).click();*/

       int finalCount = count;
        while (count > 0) {
            count = count - 1;
            String generatedString = RandomStringUtils.randomAlphabetic(6);
            $(byText("Добавить профиль")).click();
            $("#Name").val(generatedString);

            $("#topology_coordinates_source").click();
            sleep(200);
            $("#topology_coordinates_source-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $(byText("Далее")).click();
            $("#source_type").click();
            $("#source_type-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(16)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $("#sweep_signal_type").click();
            $("#sweep_signal_type-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $("#begin_sweep_signal_frequency", 1).val("9999");
            $("#avg_explosive_weight", 1).val("999999999,99");

            $("#acquisition_method").click();
            $("#acquisition_method-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $("#source_grouping_base", 1).val("999999999.99");
            $("#shotpoint_step", 1).val("999999999.99");

            $("#seismic_detector").click();
            $("#seismic_detector-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(13)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $("#receiving_base", 1).val("999999.99");

            $("#observing_system").click();
            $("#observing_system-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(10)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();


            $("#min_moving_ep_rp", 1).scrollIntoView(true).val("9999999");
            $("#receiver_grouping_base", 1).val("3312");

            $("#seismic_station").click();
            $("#seismic_station-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(10)").scrollIntoView(true).click();
            $$(".dx-button-text").findBy(text("Выбрать")).click();

            $("#amplification", 1).val("223");
            $("#discrecity", 1).val("123");
            $("#checkpoint", 1).val("554");
            $("#filtration", 1).val("123");
            $("#record_length", 1).val("312");
            $("#station_quantity", 1).val("1230");
            $("#filtration", 1).val("33");
            $("#group_device_quantity", 1).scrollIntoView(true).val("13");
            $("#max_moving_ep_rp", 1).val("13");
            $("#active_channel_quantity", 1).val("13");
            $("#receiver_point_step", 1).val("13");
            $("#multiplicity", 1).val("13");
            $("#shotpoint_moving", 1).scrollIntoView(false).val("13");
            $("#accumulation_quantity", 1).val("13");
            $("#well_quantity", 1).val("13");
            $("#source_grouping", 1).val("13");
            $("#end_sweep_signal_frequency", 1).val("13");
            $("#well_depth", 1).val("13");
            $("#sweep_signal_duration", 1).val("130");
            $("#wizard-submit-btn").click();
            assertEquals(title(), "Методика полевых работ");
            sleep(2000);
        }
        $(".dx-datagrid-summary-item").shouldHave(text("Кол-во: "+ finalCount));
    }
    void l3dSurveyCreate(){
        $("#surveyType").click();
        $(byText("Наземная 3D")).click();
        $(byText("Поиск")).click();

        $(byText("Добавить съёмку")).click();

        String generatedString = RandomStringUtils.randomAlphabetic(3);
        $("#Name").val("Autotest_" + generatedString);
        $("#ExpeditionOrganizationId").click();

        $("#" + $("#ExpeditionOrganizationId").getAttribute("aria-owns")).$(".dx-item:nth-child(4)").click();
        $("#WorkMethodId").click();

        $("#" + $("#WorkMethodId").getAttribute("aria-owns")).$(".dx-item:nth-child(4)").click();

        $("#WorkStatusId").click();
        sleep(500);
        $("#WorkStatusId-datagrid").$(".dx-row:nth-child(4)").doubleClick();

        $("#WorldRegionId").click();

        $("#" + $("#WorldRegionId").getAttribute("aria-owns")).$(".dx-item:nth-child(7)").click();

        $("#ExecutingOrganizationId").click();

        $("#" + $("#ExecutingOrganizationId").getAttribute("aria-owns")).$(".dx-item:nth-child(15)").scrollIntoView(true).click();

        $("#SubjectId").click();
        sleep(500);
        $("#subject-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(15)").scrollIntoView(true).doubleClick();

        $("#WorkVolume").val("34562");
        $("#StartDate").val("2022");
        $("#EndDate").val("2022");
        $("#Comment").val("selenide test");

        $("#topology_coordinates_source").click();
        sleep(200);
        $("#topology_coordinates_source-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").doubleClick();

        $(".dx-icon-more").click();
        sleep(500);
        $$(".dx-popup-content").get(7).$(".dx-texteditor-input").val("full name field");
        $$(".dx-checkbox-icon").get(7).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $(byText("Далее")).click();

        $("#source_type").click();
        $("#source_type-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(16)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#sweep_signal_type").click();
        $("#sweep_signal_type-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#begin_sweep_signal_frequency", 1).val("9999");
        $("#avg_explosive_weight", 1).val("99999,99");

        $("#acquisition_method").click();
        $("#acquisition_method-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(3)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#source_grouping_base", 1).val("99999.99");
        $("#shotpoint_step", 1).val("999999.99");
        $("#well_depth", 1).val("13");
        $("#sweep_signal_duration", 1).val("130");
        $("#end_sweep_signal_frequency", 1).val("21");
        $("#source_grouping",1).val("2");
        $("#well_quantity",1).val("4");
        $("#accumulation_quantity",1).val("23");
        $("#excitation_lines_distance", 1).val("2");
        $("#multiplicity", 1).val("13");

        $("#seismic_detector").click();
        $("#seismic_detector-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(13)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#observing_system").click();
        $("#observing_system-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(10)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#min_moving_ep_rp", 1).scrollIntoView(true).val("9999");
        $("#receiver_grouping_base", 1).val("3312");

        $("#seismic_station").click();
        $("#seismic_station-datagrid").$$(".dx-datagrid-table").get(1).$(".dx-row:nth-child(10)").scrollIntoView(true).click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#amplification", 1).val("223");
        $("#discrecity", 1).val("123");
        $("#checkpoint", 1).val("554");
        $("#filtration", 1).val("123");
        $("#record_length", 1).val("312");

        $("#filtration", 1).val("33");
        $("#group_device_quantity", 1).scrollIntoView(true).val("13");
        $("#max_moving_ep_rp", 1).val("13");
        $("#active_channel_quantity", 1).val("13");
        $("#x_cdp",1).val("33");
        $("#receiving_line_step",1).val("3");
        $("#multiplicity",1).val("4");
        $("#y_cdp",1).val("1");
        $("#receiver_centers_step",1).val("4");
        $("#overlap_method").click();

        $$("#" + $("#overlap_method").getAttribute("aria-owns")).get(0).$(".dx-row:nth-child(3)").click();
        $$(".dx-button-text").findBy(text("Выбрать")).click();

        $("#active_line_quantity", 1).scrollIntoView(false).val("13");
        $("#wizard-submit-btn").click();
        assertEquals(title(), "Методика полевых работ");

        sleep(300);
    }
}
