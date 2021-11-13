package ru.apolonov;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SearchWikiTest {
    private final String url = "https://github.com/";

    @Test
    void searchCodeJunit() {

        // Открыть страницу Selenide в Github
        open(url);
        $("[data-test-selector = nav-search-input]").setValue("selenide").pressEnter();
        $(".repo-list li a").shouldHave(text("selenide/selenide")).click();

        // Перейти в раздел Wiki проекта
        $$(".UnderlineNav-body li").get(5).click();

        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").$("ul").$$("li a").findBy(text("Soft assertions")).click();

        // Открыть страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }


}
