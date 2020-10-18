package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "irina_moroshek@mail.ru";
    public static final String PASSWORD = "iae062322";

    //вынесли определние driver сюда, чтоб в других классах можно было инициализировать
    WebDriver driver;


    @BeforeMethod
    //метод, который открывает сайт https://trello.com/ общий для всех классов
    public void openAppl() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.get("https://trello.com/");

    }

    @AfterMethod
    //метод, котрый прекращает работу, общий для всех классов
    public void tearDown() {

        driver.quit();
   }

}


