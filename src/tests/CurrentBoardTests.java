package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {
       //кликаем на кнопку войти
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
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
        WebElement ioginBatton2 = driver.findElement(By.id("login-submit"));
        ioginBatton2.click();
        Thread.sleep(20000);
        //находим поле QA-Haifa7 board кликаем на него
        WebElement BoardBattonHaifa7 = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA-Haifa7']]"));
        BoardBattonHaifa7.click();
        Thread.sleep(5000);
    }

    //Sel-07
    @Test
    public void AddListЕToBoardPositive() throws InterruptedException {
        //вывсети количество списков на доске QA-Haifa7
        System.out.println("Quantity of lists on the board:" + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        Thread.sleep(5000);
        //создать лист на доске
        WebElement AddAList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        AddAList.click();
        Thread.sleep(5000);
        //дать название новому листу
        WebElement AddListTitle = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        AddListTitle.sendKeys("Test");
        Thread.sleep(5000);
        //нажать на кнопку - add list, добавить лист на доску
        WebElement AddList = driver.findElement(By.xpath("//input[@class = 'primary mod-list-add-button js-save-edit']"));
        AddList.click();
        Thread.sleep(5000);
        //вывсети количество списков на доске QA-Haifa7 после добавления листа
        System.out.println("Quantity of lists on the board after adding a new list:" + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        Thread.sleep(5000);

    }

    //Sel-09
    @Test
    public void putAnyListToArchive() throws InterruptedException {
        //напечатать количество листов на доске вначале
        System.out.println("Quantity of lists on the board before sending the list at the beginning: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
        Thread.sleep(10000);
        //проверить есть ли списки, если списков нет, то добавить список
        WebElement addList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        if (addList.getText().equals("Add a list")) {
            addList.click();
        }
        else {
            addList.click();
        }
        Thread.sleep(5000);
        //дать название новому листу
        WebElement AddListTitle = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        AddListTitle.click();
        AddListTitle.clear();
        AddListTitle.sendKeys("Test");
        Thread.sleep(5000);
        //нажать на кнопку - add list
        WebElement AddList = driver.findElement(By.xpath("//input[@class = 'primary mod-list-add-button js-save-edit']"));
        AddList.click();
        Thread.sleep(5000);
        //вывсети количество списков на доске QA-Haifa7 после добавления листа
        System.out.println("Lists quantity before archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        Thread.sleep(5000);
        //нажать кнопку меню листа
        WebElement MenuList = driver.findElement(By.xpath("//a[@class = 'list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
        MenuList.click();
        Thread.sleep(5000);
        //выбрать опцию добавить лист в архив и кликнуть на нее
        WebElement ArchiveList = driver.findElement(By.xpath("//a[@class = 'js-close-list']"));
        ArchiveList.click();
        Thread.sleep(5000);
        //вывсети количество списков на доске QA-Haifa7 после помещения листа в аврхив
        System.out.println("Lists quantity after archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        Thread.sleep(5000);
    }
}

