package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class ProfileVisabilityTest extends TestBase{
        @BeforeMethod
        public void initTests() {
            //кликаем на кнопку войти
            WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
            loginIcon.click();

            waitUntilElementIsClickable(By.id("user"),15);

            // находим поле логин, кликаем, очищаем
            WebElement loginField = driver.findElement(By.id("user"));
            loginField.click();
            loginField.clear();
            loginField.sendKeys(LOGIN);

           //находим и нажимаем кнопку войти
            WebElement loginAttlButton = driver.findElement(By.id("login"));
            loginAttlButton.click();

            waitUntilElementIsClickable(By.id("password"),20);
            waitUntilElementIsClickable(By.id("login-submit"),10);

            //находим поле password кликаем на него, очищаем
            WebElement passwordAttlField = driver.findElement(By.id("password"));
            passwordAttlField.click();
            passwordAttlField.clear();
            passwordAttlField.sendKeys(PASSWORD);
            driver.findElement(By.id("login-submit")).click();

            waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),40);

            //находим поле QA-Haifa7 board кликаем на него, открываем доску QA-Haifa7
            WebElement qa7HaifaBoard = driver.findElement(By
                    .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA-Haifa7']]"));
            qa7HaifaBoard.click();
            waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
            waitUntilElementIsPresent(By.tagName("h1"),10);

            // открываем страницу Profile and Visability
            waitUntilElementIsClickable(By.xpath("//button[@aria-label = 'Open Member Menu']"),10);
            //находим иконку с именем и кликаем на нее
            driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']")).click();

            waitUntilElementIsClickable(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),10);
           //находим в меню Profile and Visability
            driver.findElement(By.xpath("//a[@data-test-id = 'header-member-menu-profile']")).click();

            waitUntilElementIsClickable(By.xpath("//input[@name='username']"),10);
            waitUntilElementIsVisible(By.xpath("//a[@data-tab='profile']"),10);
        }
        @Test
      //проверка стораницы Profile and Visability
        public void isProfileVisabilityPage(){
            WebElement profileTab = driver.findElement(By.xpath("//a[@data-tab='profile']"));
            Assert.assertEquals(profileTab.getText(), "Profile and Visibility");
        }

        @Test
        //проверка совпадения user name
        public void userNameVerification(){
            //достать имя с иконки
            WebElement memberMenuIcon = driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']"));
            String titleMenu = memberMenuIcon.getAttribute("title");
            System.out.println("Title: " + titleMenu);
            String userNameInTitle = titleMenu.substring(titleMenu.indexOf("(")+1,titleMenu.length()-1);
           //достать имя с поля Username
            WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
            System.out.println("Username: " + userNameField.getAttribute("value"));
           //проверить совпадение имен
            Assert.assertEquals(userNameInTitle, userNameField.getAttribute("value"));
        }
    }

