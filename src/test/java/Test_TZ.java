import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Test_TZ extends Settings{

    @Test
    public void test(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.openLinck(); //открываем ссылку

        mainPage.setCatalog(); //Нажимаем на ВСе категории
        waiting(); // Ожидание
        mainPage.petProduct(); // наводим курсором на товары
        mainPage.setDelicacy(); // Кликаемм по лакомству
        mainPage.setFilter();// переходим в настройки фильтра

        mainPage.setWhiskas();// выбираем производителя Whiskas
        mainPage.setShowAll(); //применяем фильтр
        mainPage.setDelivery();//Способ доставки
        mainPage.setParamMin();//минимальная цена
        mainPage.setParamMax();//Максимальная цена
        waiting();
            // Записываем название товара в переменную
        String firstName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]")).getText();
        System.out.println(firstName);
        mainPage.setFirstElement(); //Выбираем первый товар

        mainPage.setCompare();//Добавляем в сравнение
        driver.navigate().back();//клик на страницу назад


        mainPage.setFilter();//переходим в фильтр
        mainPage.setWhiskas();//Убираем производителя
        mainPage.setMniams();//добавляем производителя
        mainPage.setShowAll();//применяем фильтр
        waiting();

        String secondName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/a[1]")).getText();
        System.out.println(secondName);
        mainPage.setSecondElement();
        mainPage.setCompare();
        waiting();
        mainPage.setComparison();//Переходим в "Сравнение"

        //Проверяем есть ли на дисплее данные, которые мы собрали в переменную
        driver.findElement(By.linkText(secondName)).isDisplayed();
        driver.findElement(By.linkText(firstName)).isDisplayed();

        //10.	Проверить, что сумма стоимостей товаров не превышает 300 руб, не совсем понял, что именно требуется, проверить по 1 товару, не дороже ли они 300р? Или я не нашел, выводится
        // где-то общая сумма товара.

        //Наводим курсор на элемент, для того, чтобы потом его удалить
        WebElement element = driver.findElement(By.linkText(firstName));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waiting();
        mainPage.setDelWhiskas();//Удалаем элемент
        waiting();
        //К сожалению не смог придумать, как сделать првоерку на то, что товара нет в списке.
//        if (driver.findElement(By.linkText(firstName)).isDisplayed()){
//            System.out.println("1");
//        } else {
//            System.out.println("2");
//        }

        mainPage.setFullDel();//Очищаем полностью
        waiting();
        mainPage.setNoItem();//Проверяем, что товаров нет
    }



}
