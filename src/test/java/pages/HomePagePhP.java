package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.custom.library.BasePage;



public class HomePagePhP extends BasePage{
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public HomePagePhP() {
		// TODO Auto-generated constructor stub
	}
	
	final static Logger logger = Logger.getLogger(HomePagePhP.class);
	
	// 1- Scenario- launch the website
	

	public HomePagePhP goto_PhPeWebsite() {
		driver.get("http://www.phptravels.net");
		String websiteTitle = driver.getTitle();
		System.out.println("the website title is :" + websiteTitle);
		String expectedTitle = ("PHPTRAVELS | Travel Technology Partner");
		assertEquals(websiteTitle, expectedTitle);

		return this;
		
		
	}
	
	public SignUpPage ClickAccountSignUp() throws InterruptedException{
		
		WebElement invisibleElem = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
		js.executeScript("arguments[0].click();", invisibleElem);

		Thread.sleep(1 * 1000);

		WebElement invisibleElem2 = driver.findElement(By.xpath("//*[@id='li_myaccount']/ul/li[2]/a"));
		js.executeScript("arguments[0].click();", invisibleElem2);
		return new SignUpPage();

	}
	public LogInPage ClickAccountLogIn() throws InterruptedException{
		
		/*WebElement invisibleElem = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
		js.executeScript("arguments[0].click();", invisibleElem);

		Thread.sleep(1 * 1000);*/

		WebElement invisibleElem2 = driver.findElement(By.xpath("//*[@id='li_myaccount']/ul/li[1]/a"));
		js.executeScript("arguments[0].click();", invisibleElem2);
		return new LogInPage();
		
		

	}
	
	
	
	//verify logo displayed
	
	//we need javascript executor
	
	
	public HomePagePhP VerifyLogo(){
		//JavascriptExecutor js = (JavascriptExecutor) driver;

	//WebElement LogoFile = 	driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/a/img"));
	//WebElement Logo= 
			driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/a/img")).isDisplayed();
  // Boolean ImagePresent = (Boolean) (js).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", LogoFile);

	
	//Assert.assertTrue(ImagePresent,  "Logo is not displayed");
	System.out.println("Logo is displayed");
	
	
	
    
  //We can also use .isDisplayed method with a if/else statement
    
 /*   if (!driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/a/img")).isDisplayed()
)
    {
         System.out.println("Image not displayed.");
    }
    else
    {
        System.out.println("Image displayed.");
    }
*/
	
		return this;
	}
	//verify currency
	
	public HomePagePhP VerifyCurrency() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*List<WebElement> Currency= driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/ul/li[2]/ul"));
		for(WebElement option:Currency){
			System.out.println(option.getText());
		}
		*/
		
		//default currency

		WebElement Defaultcurrency = driver.findElement(By.cssSelector(
				"body > div.tbar-top.hidden-sm.hidden-xs > div > div > div.col-md-6.col-sm-8.col-xs-5.go-left > ul > li.dropdown > a"));
		String curr = Defaultcurrency.getText();
		System.out.println("The default currency is : " + curr);
		

		WebElement invisibleElem = driver.findElement(By.xpath("//ul[@class='dropdown-menu wow fadeIn animated']"));
		js.executeScript("arguments[0].click();", invisibleElem);

		Thread.sleep(1 * 1000);

		WebElement invisibleElem1 = driver
				.findElement(By.xpath("//a[@class='go-text-right' and contains(text(), 'USD')]"));
		js.executeScript("arguments[0].click();", invisibleElem1);
		Thread.sleep(1000);
		//currency selected

		WebElement currencySelected = driver.findElement(By.cssSelector(
				"body > div.tbar-top.hidden-sm.hidden-xs > div > div > div.col-md-6.col-sm-8.col-xs-5.go-left > ul > li.dropdown > a"));
		js.executeScript("arguments[0].click();", currencySelected);
		String text = currencySelected.getText();
		System.out.println("The currency selected is :" + text);
		
		//assertion

		Assert.assertTrue(text.contains("USD"), "Currency not updated");
		System.out.println("The currency section updated successfully");

		return this;
	}
	
	// click on Flight Icon
	// test case: when we click the flight icon, the browser should navigate to
	// the flight section
	public PhP_Flight ClickFlightLink() throws Exception {

		// driver.findElement(By.xpath("//ul[@class='nav nav-tabs RTL
		// nav-justified']/li[2]")).click();

		WebElement flights = driver.findElement(By.xpath("//span[@class='hidden-xs' and contains(text(), 'Flights')]"));
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].click();", flights);

		Thread.sleep(2000);
		
		return new PhP_Flight();

	}
	

	
	
	public HomePagePhP Hotel_Search(){
	 
		//WebElement location= 
				driver.findElement(By.partialLinkText("Search by Hotel or City Name")).click();
		
		
		 return this;
	}
		 
			// test case: when we click the Tours icon, the browser should navigate to
			// the Tours section
			public Tours ClickToursLink() throws Exception {

				WebElement Tours = driver.findElement(By.xpath("//span[@class='hidden-xs' and contains(text(), 'Tours')]"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;

				jse.executeScript("arguments[0].click();", Tours);

				Thread.sleep(2000);
				
				return new Tours();

			} 
			
			// test case: when we click the Cars icon, the browser should navigate to
						// the Tours section
						public Cars ClickCarsLink() throws Exception {

							WebElement Cars = driver.findElement(By.xpath("//span[@class='hidden-xs' and contains(text(), 'Cars')]"));
							JavascriptExecutor jse = (JavascriptExecutor) driver;

							jse.executeScript("arguments[0].click();", Cars);

							Thread.sleep(2000);
							
							return new Cars();

						}
						}
			
			
		 
	// 2-Test Scenario: Validate the login page
	
	

	/*
	public HomePagePhP Reserv_Details() throws InterruptedException{
		  driver.switchTo().frame(0);
			 WebElement Oneway = driver.findElement(By.xpath("//span[@class='ng-scope' and contains(text(), 'One way')]"));	


	}
			 

	

		/*WebElement flights = driver.findElement(By.xpath("//span[@class='hidden-xs' and contains(text(), 'Flights')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].click();", flights);
		Thread.sleep(2);
		//select 1 way
		  driver.switchTo().defaultContent();

		List<WebElement>radioButton = driver.findElements(By.id("trip-type-radio-group"));
		 System.out.println(radioButton.size());
	
		  action.moveToElement(Oneway).build().perform(); Oneway.click();

		// jse.executeScript("arguments[0].click();", Oneway);
			Thread.sleep(2);


		 boolean checkBoxState = Oneway.isSelected();
		if (isCheck == true) // user wanted to select the check-box
		{
			if (checkBoxState == true) // if box is checked by default
			{
				// do nothing
			} else // box is Not checked by default
			{
				Oneway.click();
			}
		} else { // user Do not want to select the check- box
			if (checkBoxState == true) {
				Oneway.click();
			} else {
				// Do nothing
			}
		}
		Thread.sleep(500);
		
		jse.executeScript("arguments[0].click();", Oneway);

		Oneway.click();
		
		boolean isToolTipDisplayed3 = driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).isDisplayed();
		 System.out.println("Is Tooltip displayed ? : " + isToolTipDisplayed3);
		             if (isToolTipDisplayed3) {
		                 String tooltipText3 = driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText();
		 System.out.println("Tooltip Text 3:- " + tooltipText3);
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(Oneway));
		
		WebElement origin= driver.findElement(By.xpath("//input[@placeholder='Enter departure city']"));
		
		//jse.executeScript("arguments[0].scrollIntoView()", origin);

			//jse.executeScript("arguments[0].click();", origin);

		

		
		
	/*	WebElement myDynamicElement = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter departure city']")));
		
		Thread.sleep(2);

		origin.sendKeys("Atlanta");*/
	

		/*WebElement destination= driver.findElement(By.xpath("//input[@id='airports-inline-dest-d8399cbf-5e42-4be3-a0bd-864907f30e59']"));
		Thread.sleep(2);
		destination.sendKeys("Dulles");
		Thread.sleep(2);
		*/
		/*WebElement Passenger_DropD= driver.findElement(By.xpath("//div[@class='mewtwo-flights-trip_class-wrapper']"));
		Passenger_DropD.click();
		//List<web>Travelors= driver.findElements(By.xpath("//div[@class='mewtwo-passengers-ages']"));
*/		
		//return this;



	


/*WebElement invisibleElem2 = driver.findElement(By.xpath("//*[@class='dropdown']/ul/li[1]/a"));
WebElement currency= driver.findElement(By.xpath("//a[@onclick='change_currency(this)']"));
System.out.println(currency.getText());

//List<WebElement> invisibleElem1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu wow fadeIn animated']"));			
//	js.executeScript("arguments[0].click();", invisibleElem);		
Thread.sleep(1*1000);

for(WebElement option:invisibleElem1){
	//option.getTagName()
	
	System.out.println(option.getTagName());*/
//}

/*driver.get("http://www.phptravels.net");
Thread.sleep(2 * 1000);
// Get Title of a WebPage
JavascriptExecutor js = (JavascriptExecutor) driver;
String sText = js.executeScript("return document.title;").toString();
System.out.println("The website  title is  :" + sText);*/
