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
public class Survey {
    private Map<String, Object> vars;
    public int typeSurvey = 4;
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
        login.authorization(2);
        $(byTitle("Домашняя страница")).shouldBe(visible);
    }

    @Test
    @Order(2)
        //Вход в Методику
    void goToSurvey() {
        $(byAttribute("href", "/Survey")).click();
    }

    @Test
    @Order(3)
    void selectSurveyType() {
        SurveyId_1 land2d = new SurveyId_1();
//        land2d.l2DSurveyCreate();
//        land2d.l2dSampleCreate(2);
        land2d.l3dSurveyCreate();
    }

}
