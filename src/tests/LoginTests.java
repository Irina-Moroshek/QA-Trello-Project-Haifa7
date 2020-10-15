package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void initTests() {

        //кликаем на кнопку войти
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.xpath("//*[@class='btn btn-sm btn-link text-white']"),20);
    }

        @Test
        public void loginNegativeLoginEmpty ()  {
            //ждем пока элемент станет активным
            waitUntilElementIsClickable(By.id("login"),10);

        // находим поле password кликаем на него, очищаем, вводим пароль
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(PASSWORD);

            //находим кнопку ввод, кликаем на нее
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            //ждем пока появится нужный элемент - сообщение об ошибке, чтобы элемент стал виден
           // waitUntilElementIsPresent(By.id("error"), 30);
            waitUntilElementIsVisible(By.id("error"), 30);
            //выводим сообщение об ошибке
            System.out.println("Error: " + driver.findElement(By.id("error")).getText());
            Assert.assertEquals(driver.findElement(By.id("error")).getText(),
                    "Missing email",
                    "The text of the error message is not correct");
        }

        //Sel-04
        @Test
        public void loginNegativeNonexistentLoginAndPassword ()  {
            waitUntilElementIsClickable(By.id("login"),10);

            // находим поле логин, кликаем, очищаем
            WebElement loginField = driver.findElement(By.id("user"));
            loginField.click();
            loginField.clear();
            //вводим в поле логин несуществующий логин
            loginField.sendKeys("i_mor@mail.ru");

            //находим поле password кликаем на него, очищаем
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.click();
            passwordField.clear();
            //вводим в поле логин несуществующий пароль
            passwordField.sendKeys("1234567");

            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            //waitUntilElementIsClickable(By.id("error"),30);
            waitUntilElementIsVisible(By.id("error"), 30);
            //выводим сообщение об ошибке
            System.out.println("Error: " + driver.findElement(By.id("error")).getText());
            Assert.assertEquals(driver.findElement(By.id("error")).getText(),"There isn't an account for this email");


        }

        //Sel-05
        @Test
        public void loginNegativeNonexistentPassword () {
            waitUntilElementIsClickable(By.id("login"),10);
           // находим поле логин, кликаем, очищаем
            WebElement loginField = driver.findElement(By.id("user"));
            loginField.click();
            loginField.clear();
            //вводим в поле логин существующий логин
            loginField.sendKeys(LOGIN);

            //находим и нажимаем кнопку войти
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            waitUntilElementIsClickable(By.id("login-submit"), 30);
           //находим поле password кликаем на него, очищаем
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.click();
            passwordField.clear();
            //вводим в поле логин несуществующий пароль
            passwordField.sendKeys("1234567");

            //находим и нажимаем кнопку войти
            WebElement login = driver.findElement(By.id("login-submit"));
            login.click();

            //waitUntilElementIsClickable(By.id("error"),30);
            waitUntilElementIsVisible(By.cssSelector("#login-error"), 30);
            //выводим сообщение об ошибке
            System.out.println("Error: " + driver.findElement(By.cssSelector("#login-error")).getText());
            Assert.assertTrue(driver.findElement(By.cssSelector("#login-error")).getText().contains("Incorrect email address and / or password."),
                            "Do you need help logging in?");
        }

        //Sel-06
        @Test
        public void loginPositiveTest ()  {
            waitUntilElementIsClickable(By.id("login"),10);

        // находим поле логин, кликаем, очищаем
            WebElement loginField = driver.findElement(By.id("user"));
            loginField.click();
            loginField.clear();
            //вводим в поле логин существующий логин
            loginField.sendKeys(LOGIN);

            waitUntilElementIsClickable(By.id("login"),10);
            //находим и нажимаем кнопку войти
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            waitUntilElementIsClickable(By.id("login-submit"), 10);
            //находим поле password кликаем на него, очищаем
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.click();
            passwordField.clear();
            //вводим в поле логин существующий пароль
            passwordField.sendKeys(PASSWORD);

            //находим и нажимаем кнопку войти
            WebElement login = driver.findElement(By.id("login-submit"));
            login.click();

            waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),20);

            System.out.println("Boards button text: " + driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']")).getText());
            Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id ='header-boards-menu-button']"))
                    .getText().equals("Boards"),"The text on the button is not 'Board'");





        }
    }


