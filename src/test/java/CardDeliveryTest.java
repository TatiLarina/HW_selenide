import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldValid() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[name='name']").setValue("Иванова Анна");
        $("[name='phone'").setValue("+79111111111");
        $x("//span[contains(@class, 'checkbox__box')]").click();
        $x("//button[contains(@class, 'button_view_extra')]").click();
        $x("//*[contains(text(), 'Успешно')]").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}
