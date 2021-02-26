# worki.ru tests
## Использованные инструменты:
* Java
* Gradle
* JUnit5
* Owner
* Selenide
* Jenkins
* Selenoid
* Allure Report
* Allure TestOps (EE)
* Telegram Notifications
* Jira

## Скриншоты
***
Запуск тестов организован в Jenkins. Посмотреть можно по ссылке https://jenkins.autotests.cloud/job/C03-kam75-worki/  
Тесты могут запускаться параллельно.
***
### Allure Report 
***
Отчет о прохождении тестов Allure Report можно посмотреть по ссылке https://jenkins.autotests.cloud/job/C03-kam75-worki/3/allure/
***
![alt-AllureReport](src/test/resources/images/AllureReport1.png "AllureReport")
![alt-AllureReport](src/test/resources/images/AllureReport2.png "AllureReport")
![alt-AllureReport](src/test/resources/images/AllureReport3.png "AllureReport")
### Selenoid
***
Для контейнеризации тестов использован Selenoid.
***
![alt-Selenoid](src/test/resources/images/Selenoid.gif "Selenoid")
### Allure TestOps (EE) 
***
В качестве системы управления тестами использован Allure TestOps.  
***
![alt-AllureTestOps](src/test/resources/images/AllureTestOps1.png "AllureTestOps")
![alt-AllureTestOpsv](src/test/resources/images/AllureTestOps2.png "AllureTestOps")
![alt-AllureTestOpsv](src/test/resources/images/AllureTestOps3.png "AllureTestOps")
### Jira
***
Создана задача в Jira. К ней добавлены тест-кейсты, информация о запусках тестов.
***
![alt-Jira](src/test/resources/images/Jira.png "Jira")
***
### Telegram Notifications
***
После окончания тестов результаты отправляются в Telegram
***
![alt-TelegramNotifications](src/test/resources/images/Telegram.png "Telegram")




