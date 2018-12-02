package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.custom.library.BasePage;

public class BookFlightHelper extends BasePage{
	
	@Test
	
	public void myTrip() throws Exception{
		
		driver.get("http://www.phptravels.net");
		Thread.sleep(2 * 1000);
		// Get Title of a WebPage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sText = js.executeScript("return document.title;").toString();
		System.out.println("The website  title is  :" + sText);

		// click on Flight Icon

		driver.findElement(By.xpath("//ul[@class='nav nav-tabs RTL nav-justified']/li[2]")).click();

		Thread.sleep(2000);
		driver.getTitle();
		Assert.assertTrue(driver.getTitle().contains("Flights"), "Flights Icons does not navigate to th enext section");
		System.out.println("Flights Icon verified.- User is able to navigate to the Flight section");

		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe);
		Thread.sleep(2000);

		// select oneway option
		// List<WebElement> TripOption =
		// driver.findElements(By.xpath("//*[@id='trip-type-radio-group']"));
		driver.findElement(By.xpath("//*[@id='trip-type-radio-group']"));
		Thread.sleep(1 * 1000);
		 driver.findElement(By.xpath("//*[@id='trip-type-radio-group']/label[1]")).click();
		Thread.sleep(1 * 2000);
		
		selectTravelorTypeNumber("adult", "4");
		
	}
	
	
/////helper
	
	public void selectTravelorTypeNumber(String travelorType, String travelorNumber) throws Exception {
		 driver.findElement(By.xpath("//span[@id='add-traveller-link']")).click();
		 
		 WebElement dropDownElem = driver.findElement(By.xpath("//ts-search-travellers[@class='floating-travellers ng-scope ng-isolate-scope']"));

		dropDownElem.findElements(By.xpath("//div[@class='traveller-form']"));
		 List<WebElement> stepperElems = dropDownElem.findElements(By.xpath("//div[@class='stepper item-list--action ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-out-of-bounds']"));
				// findElements(By.xpath("//div[@class='item']"));

		 
		 
		 for (WebElement option : stepperElems) {
				myLib.highlightElement(option);
				String txt = option.getAttribute("label");
				
				System.out.println(txt);
				
		 }
		 
		 WebElement plusSign = driver.findElement(By.xpath("//button[@class='stepper--plus']"));
		// WebElement TravelNumb= driver.findElement(By.xpath("//input[@class='stepper-text ng-pristine ng-valid ng-touched']"));
		 WebElement alert= driver.findElement(By.xpath("//span[@class='ng-binding ng-scope']"));
		while (true){
			plusSign.click();
			if(alert.getText().contains("maximum")){
				
				System.out.println(alert.getText());
				break;
			}
		}
		

		 /*
				if (txt.contains(travelorType)) {
					List<WebElement> icons = option.findElements(By.tagName("button"));
					//System.out.println(icons.size());
					WebElement plusIcon = icons.get(1);
					int traNum = Integer.parseInt(travelorNumber);
					for (int i = 1; i <= traNum; i++) {
						plusIcon.click();
						myLib.customWait(0.5);
					}
					break;
				}
	}*/
	
  

}
}
