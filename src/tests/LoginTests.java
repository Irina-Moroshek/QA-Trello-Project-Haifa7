package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //кликаем на кнопку войти
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
    }
    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {
        //находим поле password кликаем на него, очищаем, вводим пароль
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        //находим кнопку ввод, кликаем на нее
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //выводим сообщение об ошибке
        System.out.println("Error: " + driver.findElement(By.id("error")).getText());
    }
    //Sel-04
    @Test
    public void loginNegativeNonexistentLoginAndPassword() throws InterruptedException {
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
        //выводим сообщение об ошибке
        System.out.println("Error: " + driver.findElement(By.id("error")).getText());
        Thread.sleep(2000);

    }
    //Sel-05
    @Test
    public void loginNegativeNonexistentPassword () throws InterruptedException {
        // находим поле логин, кликаем, очищаем
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        //вводим в поле логин существующий логин
        loginField.sendKeys(LOGIN);
        Thread.sleep(2000);
        //находим и нажимаем кнопку войти
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //находим поле password кликаем на него, очищаем
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        //вводим в поле логин несуществующий пароль
        passwordField.sendKeys("1234567");
        //находим и нажимаем кнопку войти
        WebElement login = driver.findElement(By.id("login-submit"));
        login.click();
        Thread.sleep(2000);
        //выводим сообщение об ошибке
        System.out.println("Error: "+ driver.findElement(By.cssSelector("#login-error")).getText());
        Thread.sleep(2000);

    }
    //Sel-06
    @Test
    public void loginPositiveTest () throws InterruptedException {
        // находим поле логин, кликаем, очищаем
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        //вводим в поле логин существующий логин
        loginField.sendKeys(LOGIN);
        Thread.sleep(5000);
        //находим и нажимаем кнопку войти
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        //находим поле password кликаем на него, очищаем
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        //вводим в поле логин существующий пароль
        passwordField.sendKeys(PASSWORD);
        Thread.sleep(5000);
        //находим и нажимаем кнопку войти
        WebElement login = driver.findElement(By.id("login-submit"));
        login.click();
        Thread.sleep(10000);
        System.out.println("Boards button text: " + driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']")).getText());
        Thread.sleep(2000);
    }
}


