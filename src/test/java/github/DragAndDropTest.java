package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

//Запрограммируйте Drag&Drop с помощью Selenide.actions() - не выполнено
//Откройте https://the-internet.herokuapp.com/drag_and_drop
//Перенесите прямоугольник А на место В
//Проверьте, что прямоугольники действительно поменялись
//В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест,если использовать её вместо actions()


public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Перемещение прямоугольников c использованием dragAndDrop")
    void softAssertionsTestExample() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
        Selenide.sleep(5000);
    }
}
