package com.olegzxcv.technical.task;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
class VacancyTest {
  public static final By XPATH_CAREERS = By.xpath(".//*[(@class = 'reload-page') and text() = 'Careers']");
  public static final By XPATH_VACANCIES = By.xpath(".//*[(@class = 'reload-page') and text() = 'Vacancies']");
  public static final By XPATH_TEST_AUTOMATION = By.xpath(".//*[contains(@class,'menu-link') and text() = 'TEST AUTOMATION ENGINEER vacancy']");
  public static final By XPATH_SKILL_LIST = By.xpath(".//h1[text() = 'TEST AUTOMATION ENGINEER vacancy']/..//p/strong[text() = 'Professional skills and qualification:']/../following::ul[1]/li");
  public static final int EXPECTED_LIST_SIZE = 8;
  public static final String HTTPS_CTCO_LV_EN = "https://ctco.lv/en";

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @Test
  void VacancySkillListTest() {
    open(HTTPS_CTCO_LV_EN);
    $(XPATH_CAREERS).hover();
    $(XPATH_VACANCIES).click();
    $(XPATH_TEST_AUTOMATION).click();
    $$(XPATH_SKILL_LIST).shouldBe(CollectionCondition.size(EXPECTED_LIST_SIZE));
  }
}
