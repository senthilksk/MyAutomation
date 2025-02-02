package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import MyPrograms.InitializeDriver;

public class TestSlider extends InitializeDriver{

	WebDriver driver;

	@Test
	public void moveSlider() throws InterruptedException {

		driver = initDriver();
		driver.get("https://jqueryui.com/slider/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement mainSlider = driver.findElement(By.id("slider"));
		int width = mainSlider.getSize().width/2;
		WebElement slider =	driver.findElement(By.tagName("span"));
	//	new Actions(driver).dragAndDropBy(slider, 200,0).perform();
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, 200,0).perform(); //moving right
		actions.dragAndDropBy(slider, 200,0).perform(); //moving right
		actions.dragAndDropBy(slider, -300,0).perform(); //moving left
		actions.dragAndDropBy(slider, -100,0).perform(); //moving left
		actions.dragAndDropBy(slider, width,0).perform(); // moving to the centre of the slider		
		Thread.sleep(3000);
		driver.quit();
	}

}
