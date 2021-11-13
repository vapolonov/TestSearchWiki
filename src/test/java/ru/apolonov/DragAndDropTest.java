package ru.apolonov;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    private final String url = "https://the-internet.herokuapp.com/drag_and_drop";

    @Test
    void testDragDrop() {
        open(url);

        $$(".column").shouldHave(exactTexts("A", "B"));

        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        //Проверить, что прямоугольники действительно поменялись
        $$(".column").shouldHave(exactTexts("B", "A"));

    }
}
