package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.custom.library.BasePage;
import com.custom.library.ExcelManager;

public class PHPCurrencyTest extends BasePage{
	
	@DataProvider(name = "Currency")//data provider annotation to fetch the data from the external excel file
	public static Object[][] credentials() {
		ExcelManager reader = new ExcelManager("src/test/resources/VeriFyCurrency.xls");// create
																							
		return reader.getExcelData("Sheet1");
	}
	
			
	

		@Test(dataProvider = "Currency") // data provider annotation
		public void loginTest(String Curren_Name) throws InterruptedException{
					
			driver.get("http://www.phptravels.net");	
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement Defaultcurrency= driver.findElement(By.cssSelector("body > div.tbar-top.hidden-sm.hidden-xs > div > div > div.col-md-6.col-sm-8.col-xs-5.go-left > ul > li.dropdown > a"));
		String curr= Defaultcurrency.getText();
		System.out.println("The default currency is : " + curr);
	
		WebElement invisibleElem = driver.findElement(By.xpath("//ul[@class='dropdown-menu wow fadeIn animated']"));			
		js.executeScript("arguments[0].click();", invisibleElem);
		
		Thread.sleep(1*1000);
			
		WebElement invisibleElem1 = driver.findElement(By.xpath("//a[@class='go-text-right' and contains(text(),"+ Curren_Name+")]"));			
		js.executeScript("arguments[0].click();", invisibleElem1);
		
		Thread.sleep(2000);
		//System.out.println(driver.getTitle());
		
		WebElement currencyAfterSelect= driver.findElement(By.cssSelector("body > div.tbar-top.hidden-sm.hidden-xs > div > div > div.col-md-6.col-sm-8.col-xs-5.go-left > ul > li.dropdown > a"));
		js.executeScript("arguments[0].click();", currencyAfterSelect);

		String text= currencyAfterSelect.getText();
	
		System.out.println("The currency after new selection is :" + text);
		System.out.println(Curren_Name);	
		
	
		String CurrenUpdate=Curren_Name.replace("\"", "");
		System.out.println(CurrenUpdate);
		
		//assertEquals(text, CurrenUpdate);
		assertEquals(text, CurrenUpdate, "The currency section not updated accordingly!");
		//Assert.assertTrue(text.contains(CurrenUpdate), "currency not updated");
		System.out.println("The currency section updated successfully!");

		
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*	WebElement invisibleElem = driver.findElement(By.xpath("//ul[@class='dropdown-menu wow fadeIn animated']"));			
	js.executeScript("arguments[0].click();", invisibleElem);

	Thread.sleep(2*1000);

	List<WebElement> currency = driver.findElements(By.xpath("//a[@class='go-text-right' and @onclick='change_currency(this)']"));

//js.executeScript("arguments[0].click();", currency);

	Thread.sleep(2*1000);
	
	
	
	
	for(WebElement option: currency){
		System.out.println("the currency is : " + option.getText());
	}	
		*///driver.findElement(By.xpath("//a[@class='go-text-right' and contains(text(), 'EUR')]"));
		/*int totalCurrency = currencyDrop.size();
		System.out.println("the number of currencies is:" + totalCurrency);
		
		for(WebElement currency:currencyDrop){
			boolean visibility = currency.isDisplayed();
		if (visibility == true) {
			String linkText = "";
			linkText = currency.getText();
			System.out.println(linkText);
			
		}else {
			
			System.out.println("element not visible");
		}
				
		
	
	}*/
		
	
	
