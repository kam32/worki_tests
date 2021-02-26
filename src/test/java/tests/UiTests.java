package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class UiTests extends TestBaseUi {

    @Test
    @AllureId("")
    @Feature("Authorization")
    @DisplayName("Неуспешная авторизация")
    void unsuccessfulAuthorization() {
        step("Открываем главную страницу, нажимаем \"Вход на сайт\" ", () -> {
            open("");
            $("[data-test-id='LoginButton']").click();
        });
        step("Вводим некорректный номер телефона", () -> {
            $("[data-test-id='LoginModal'] [data-test-id='InputPhone']").val("123456").pressEnter();
        });
        step("Проверить, что появилось сообщение \"Некорректный номер\"", () -> {
            $("[data-test-id='LoginModal']").shouldHave(text("Некорректный номер"));
        });
    }

    @Test
    @AllureId("")
    @Feature("Job Categories")
    @DisplayName("Проверка количество элементов в слайдере \"Вакансии по категориям\"")
    void checkJobCategoriesSize() {
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Проверить, что количество элементов в слайдере \"Вакансии по категориям\" равно 37 ", () -> {
            $$("[data-test-id='JobCategories--Item']").shouldHaveSize(37);
        });
    }

    @Test
    @AllureId("")
    @Feature("Change City")
    @DisplayName("Проверка смены города на Новосибирск")
    void otherCitySearch() {
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Нажать кнопку \"В другом городе?\" ", () -> {
            $("[class*='jobsLandingHeader_geoChange']").click();
        });
        step("Очистить поле ввода города", () -> {
            $("[data-test-id='AutosuggestClearButton']").click();
        });
        step("Ввести \"Новосибирск\", выбрать его из списка ", () -> {
            $("input[class*='autosuggest']").val("Новосибирск");
            $$("[data-test-id='CitySuggestItem']").find(exactText("Новосибирск")).click();
        });
        step("Нажать \"Сохранить\"", () -> {
            $("button[type='submit']").click();
        });
        step("Проверить, что город поменялся на Новосибирск", () -> {
            $("[class*='jobsLandingHeader']").shouldHave(text("Новосибирске"));
        });
    }

    @Test
    @AllureId("")
    @Feature("Employer Price")
    @DisplayName("Проверить цену для работодателей")
    void checkEmployerPrice() {
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Переходим во вкладку \"Работодателям\"", () -> {
            $("[class*='navigationHeader']").$(byText("Работодателям")).click();
        });
        step("Кликаем на \"Цены\"", () -> {
            $$("a[class*='subheaderMenu']").find(text("Цены")).click();
        });
        step("Проверить, что под 1 вакансией цена 289 р.", () -> {
            $$("[class*='chartItem']").find(exactText("1 вакансия")).sibling(0).shouldHave(text("289"));
        });
    }

    @Test
    @AllureId("")
    @Feature("Search Filters")
    @DisplayName("Проверить работу фильтров поиска")
    void checkSearchFilters() {
        step("Открываем страницу с результатами поиска", () -> {
            open("https://kazan.vkrabota.ru/vacansii/?distanceTo=4&keyWord=тест&salary=1");
        });
        step("Клик на категории, выбираем удаленную работу", () -> {
            $("[data-test-id='JobsFilterCategorySelectField'] #Shape").scrollIntoView(true).click(usingJavaScript());
            $("[data-test-id='JobsFilterCategorySelectField'] [class*='dropDown']").
                    $(byText("Удаленная работа")).click(usingJavaScript());
        });
        step("Проверить, что выбрана удаленная работа", () -> {
            $("[data-test-id='JobsFilterCategorySelectField'] [class*='selectInput']").shouldHave(text("Удаленная работа"));
        });
        step("Выбрать \"Неполный рабочий день\"", () -> {
            $$("[class*='jobsFilterConditions']").find(text("Неполный рабочий день")).click();
        });
        step("Проверить, что выбран чекбокс  \"Неполный рабочий день\"", () -> {
            $$("[class*='jobsFilterConditions']").find(text("Неполный рабочий день")).parent()
                    .$("input").shouldBe(checked);
        });
    }
}


