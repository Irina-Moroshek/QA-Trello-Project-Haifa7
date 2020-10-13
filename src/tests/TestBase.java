package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "irina_moroshek@mail.ru";
    public static final String PASSWORD = "iae062322";

    //вынесли определние driver сюда, чтоб в других классах можно было инициализировать
    WebDriver driver;


    @BeforeMethod
    //метод, который открывает сайт https://trello.com/ общий для всех классов
    public void OpenAppl() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.get("https://trello.com/");
        waitUntilElementIsWebsite("https://trello.com/", 10);
        // Thread.sleep(10000);
    }

   //  @AfterMethod
    //метод, котрый прекращает работу, общий для всех классов
   // public void tearDown() {

   //     driver.quit();
  //  }

    //проверьте этот код,я придумала, для задержки веб сайта,можно так написать код?
    //ждем, пока элемент загрузится вебсайт
    public void waitUntilElementIsWebsite(String url, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ждем, пока элемент не станет активным
    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ждем, пока не появится элемент
    public void waitUntilElementIsPresent(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ждем, пока элемент не станет невидимым
    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
       } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ждем, пока элемент не станет видимым
    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ждем, пока элементы не станут видны
    public void waitUntilElementsAreVisible (By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


