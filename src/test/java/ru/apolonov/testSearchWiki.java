package ru.apolonov;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class testSearchWiki {

    @Test
    void searchCodeJunit() {

      // Откройте страницу Selenide в Github

      open("https://github.com/");
      $("[data-test-selector = nav-search-input]").setValue("selenide").pressEnter();
      $(".repo-list li a").shouldHave(text("selenide/selenide")).click();

      // Перейдите в раздел Wiki проекта
      $$(".UnderlineNav-body li").get(5).click();

      // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
      $(".markdown-body").$("ul").$$("li a").findBy(text("Soft assertions")).click();

      // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
      $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));


    }


}
