package selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class Login {
    String log;
    String pass;

    void authorization(int role) {
        switch (role) {
            case (1):
                log = "report";
                pass = "report";
                break;
            case (2):
                log = "survey";
                pass = "survey";
                break;
            case (3):
                log = "topology";
                pass = "topology";
                break;
            case (4):
                log = "processed";
                pass = "processed";
                break;
            case (5):
                log = "seismic";
                pass = "seismic";
                break;
            case (6):
                log = "interpretation";
                pass = "interpretation";
                break;
            case (7):
                log = "archive";
                pass = "archive";
                break;
            case (8):
                log = "media";
                pass = "media";
                break;
            case (9):
                log = "store";
                pass = "store";
                break;
            case (10):
                log = "admin";
                pass = "admin";
                break;
            case (11):
                log = "order";
                pass = "order";
                break;
            case (12):
                log = "statistic";
                pass = "statistic";
                break;
            default:
                log = "sovkovve";
                pass = "SOVKOVVE";
                break;
        }
        open("https://rn-sdc.dmdevelopment.ru/");
        $(byName("Login")).val(log);
        $(byName("Password")).val(pass);
        $(".dx-button-text").click();
        if ($(".alert").exists() == true) {
            authorization(0);
        }
    }
}
