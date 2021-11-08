package ru.apolonov;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class LinkText {

    @Test
    void searchCodeJunit() {

      // Открыть страницу Selenide в Github

      open("https://github.com/");
      $(".header-search-input").click();
      $(".header-search-input").sendKeys("selenide");
      $(".header-search-input").submit();
      $(".repo-list").$(linkText("selenide/selenide")).click();

      // Перейти в раздел Wiki проекта
      $(".UnderlineNav-body").$(partialLinkText("Wiki")).click();

      // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
      $(".markdown-body").$(linkText("Soft assertions")).shouldBe(visible).click();

      // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

      $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
