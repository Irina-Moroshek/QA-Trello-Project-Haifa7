package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {

    @BeforeMethod
    public void initTests() {
        waitUntilElementIsClickable(By.xpath("//*[@class='btn btn-sm btn-link text-white']"), 20);
        //кликаем на кнопку войти
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();

        waitUntilElementIsClickable(By.id("login"), 10);
        // находим поле логин, кликаем, очищаем
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        //вводим в поле логин существующий логин
        loginField.sendKeys(LOGIN);

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
        WebElement ioginBatton2 = driver.findElement(By.id("login-submit"));
        ioginBatton2.click();

         waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),45);
        //находим поле QA-Haifa7 board кликаем на него, открываем доску QA-Haifa7
        WebElement qa7HaifaBoard = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA-Haifa7']]"));

        qa7HaifaBoard.click();
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
        waitUntilElementIsPresent(By.tagName("h1"),10);
    }
    @Test
    public void isCorrectCurrentBoard() {
        System.out.println("Header of the current board: " + driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"QA-Haifa7",
                "The header of the screen is not 'QA-Haifa7'");
    }

        //Sel-07
        @Test
        public void addListToBoardPositive () {
             waitUntilElementIsPresent(By.xpath("//div[@class = 'list js-list-content']"), 30);
            int quantityListsInTheBeginning = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
            int quantityListsAtTheEnd = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();

            //вывсети количество списков на доске QA-Haifa7
            System.out.println("Quantity of lists on the board:" + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());

            //создать лист на доске
            WebElement AddAList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
            AddAList.click();

            //дать название новому листу
            WebElement AddListTitle = driver.findElement(By.xpath("//input[@class='list-name-input']"));
            AddListTitle.sendKeys("Test");

            //нажать на кнопку - add list, добавить лист на доску
            WebElement AddList = driver.findElement(By.xpath("//input[@class = 'primary mod-list-add-button js-save-edit']"));
            AddList.click();

            //  waitUntilElementIsPresent(By.xpath("//div[@class = 'list js-list-content']"), 30);
            //вывсети количество списков на доске QA-Haifa7 после добавления листа
            System.out.println("Quantity of lists on the board after adding a new list:" + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
            Assert.assertEquals(quantityListsInTheBeginning,quantityListsAtTheEnd);
        }

        //Sel-09 - если лист есть, сразу отпрвялет в архив; если листа нет - создает лист, и потом отправляет в архив
        @Test
        public void putAnyListToArchive () {
            waitUntilElementIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']"), 30);

            int quantityListsInTheBeginning = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
            int quantityListsAtTheEnd = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();

            //напечатать количество листов на доске вначале
            System.out.println("Quantity of lists on the board before sending the list at the beginning: " + driver
                    .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                    .size());

            WebElement addList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
            // WebElement addList = driver.findElement(By.cssSelector("a.open-add-list"));

            //если есть лист на доске - сразу отправить любой лист в архив
            if (addList.getText().equals("Add another list")) {
                //нажать кнопку меню листа
                WebElement MenuList = driver.findElement(By.xpath("//a[@class = 'list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
                MenuList.click();

                waitUntilElementIsPresent (By.xpath("//a[@class = 'js-close-list']"), 30);
                //выбрать опцию добавить лист в архив и кликнуть на нее
                WebElement ArchiveList = driver.findElement(By.xpath("//a[@class = 'js-close-list']"));
                ArchiveList.click();

                //если листа на доске нет, то сначала создать лист,потом отпрвить любой лист в архив
            } else {
                //создать лист на доске
                WebElement AddAList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
                AddAList.click();

                //дать название новому листу
                WebElement AddListTitle = driver.findElement(By.xpath("//input[@class='list-name-input']"));
                AddListTitle.sendKeys("Test");

                //нажать на кнопку - add list, добавить лист на доску
                WebElement AddList = driver.findElement(By.xpath("//input[@class = 'primary mod-list-add-button js-save-edit']"));
                AddList.click();

                //вывсети количество списков на доске QA-Haifa7 после добавления листа
               System.out.println("Lists quantity before archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());

                //нажать кнопку меню листа
                WebElement MenuList = driver.findElement(By.xpath("//a[@class = 'list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
                MenuList.click();

                waitUntilElementIsPresent (By.xpath("//a[@class = 'js-close-list']"), 30);
                //выбрать опцию добавить лист в архив и кликнуть на нее
                WebElement ArchiveList = driver.findElement(By.xpath("//a[@class = 'js-close-list']"));
                ArchiveList.click();
            }

            //вывсети количество списков на доске QA-Haifa7 после помещения листа в аврхив
            System.out.println("Lists quantity after archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
            Assert.assertEquals(quantityListsInTheBeginning,quantityListsAtTheEnd);
        }


    //Sel-09 - создает новый лист в любом случае: если нет листа на доске и если есть лист
    @Test
    public void addNewListAndPutAnyListToArchive() {
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']"), 30);


        int quantityListsInTheBeginning = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        int quantityListsAtTheEnd = driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();


        //напечатать количество листов на доске вначале
        System.out.println("Quantity of lists on the board before sending the list at the beginning: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());


        WebElement addList = driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        // WebElement addList = driver.findElement(By.cssSelector("a.open-add-list"));

       //если листа на доске нет, то создать лист и отправить любой лист в архив
        if (addList.getText().equals("Add a list")) {
            addList.click();

            //если лист на доске есть, создать новый лист и отправить любой лист в архив
        } else {
            addList.click();
        }

        //дать название новому листу
        WebElement AddListTitle = driver.findElement(By.xpath("//input[@class='list-name-input']"));
        AddListTitle.click();
        AddListTitle.clear();
        AddListTitle.sendKeys("Test");

        //нажать на кнопку - add list
        WebElement AddList = driver.findElement(By.xpath("//input[@class = 'primary mod-list-add-button js-save-edit']"));
        AddList.click();

        //вывсети количество списков на доске QA-Haifa7 после добавления листа
        System.out.println("Lists quantity before archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());

        //нажать кнопку меню листа
        WebElement MenuList = driver.findElement(By.xpath("//a[@class = 'list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
        MenuList.click();

        waitUntilElementIsPresent (By.xpath("//a[@class = 'js-close-list']"), 30);
        //выбрать опцию добавить лист в архив и кликнуть на нее
        WebElement ArchiveList = driver.findElement(By.xpath("//a[@class = 'js-close-list']"));
        ArchiveList.click();

        //вывсети количество списков на доске QA-Haifa7 после помещения листа в аврхив
        System.out.println("Lists quantity after archive: " + driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        Assert.assertEquals(quantityListsInTheBeginning,quantityListsAtTheEnd);
    }
}



