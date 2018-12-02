package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.custom.library.BasePage;

public class PhP_Flight extends BasePage {
	
	public PhP_Flight() {
		// TODO Auto-generated constructor stub
	}
/*	public PhP_Flight VerifyFlightPage() throws Exception {		
		
		driver.getTitle();
		// add validation point
		Assert.assertTrue(driver.getTitle().contains("Flights"), "Flights Icons does not navigate to th enext section");
		System.out.println("Flights Icon verified.- User is able to navigate to the Flight section");
	

		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe);
		

		return this;*/
	
	

	
	public PhP_Flight OneWayOption() throws InterruptedException{

		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe);
		Thread.sleep(2000);

		// select oneway option
		
		driver.findElement(By.xpath("//*[@id='trip-type-radio-group']"));
		Thread.sleep(1 * 1000);
		 driver.findElement(By.xpath("//*[@id='trip-type-radio-group']/label[1]")).click();
		Thread.sleep(1 * 2000);
		
		return this;
		
		}
	public PhP_Flight TwoWayOption() throws InterruptedException{
		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe);
		Thread.sleep(2000);
		
		// select Twoway option
		driver.findElement(By.xpath("//*[@id='trip-type-radio-group']"));
		Thread.sleep(1 * 1000);
		 driver.findElement(By.xpath("//*[@id='trip-type-radio-group']/label[2]")).click();
		Thread.sleep(1 * 2000);
		
		return this;
	}
	
	public PhP_Flight MultiCityOption() throws Exception{
		// switch to default frame since "return" is selected by default
					WebElement travelstartIframe = driver
							.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

					driver.switchTo().frame(travelstartIframe);
					Thread.sleep(2000);
					
					// select multicity option
					
					driver.findElement(By.xpath("//*[@id='trip-type-radio-group']"));
					Thread.sleep(1 * 1000);
					 driver.findElement(By.xpath("//*[@id='trip-type-radio-group']/label[3]")).click();
					Thread.sleep(1 * 2000);
					 WebElement addFlight = driver.findElement(By.xpath("//span[@id='add-flight-link']"));
					String classText = addFlight.getAttribute("class");
					 do {
							System.out.println("before click: " + classText);
							addFlight.click();
							myLib.customWait(0.5);
							classText = addFlight.getAttribute("class");
							System.out.println("after click: " + classText);
						} while (!classText.contains("disabled"));
					
		
		return this;
	}

	// select MultiCity option

	public PhP_Flight MultiCityAddFlight() throws Exception {
		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='trip-type-radio-group']/label[3]")).click();
		// Thread.sleep(1 * 1000);
		Thread.sleep(1 * 2000);
		WebElement addFlight = driver.findElement(By.xpath("//span[@id='add-flight-link']"));
		String classText = addFlight.getAttribute("class");
		do {
			System.out.println("before click: " + classText);
			addFlight.click();
			myLib.customWait(0.5);
			classText = addFlight.getAttribute("class");
			System.out.println("after click: " + classText);
		} while (!classText.contains("disabled"));

		return this;
	}

	public PhP_Flight cabinOptionList() throws InterruptedException {

		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='more-options__label']")).click();

		// cabin list of options
		List<WebElement> dropdown = driver.findElements(By.id("preferred-cabin"));
		for (WebElement option : dropdown) {
			System.out.println(option.getText());
			System.out.println(option.getAttribute("value"));
		}

		// another way

		// System.out.println(driver.findElement(By.id("preferred-cabin")).getText());
		return this;
	}

	public PhP_Flight VerifyPremiumCabin() throws InterruptedException {
		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='more-options__label']")).click();

		driver.findElement(By.id("preferred-cabin")).click();
		WebElement PremiumClass = driver.findElement(By.xpath("//*[@id='preferred-cabin']/option[4]"));
		Thread.sleep(500);
		System.out.println(PremiumClass.getText());

		System.out.println("Premium class option is :" + PremiumClass.getAttribute("value"));

		Thread.sleep(1000);

		return this;
	}

	// EconomyOption

	public PhP_Flight VerifyEconomyCabin() throws InterruptedException {

		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='more-options__label']")).click();

		driver.findElement(By.id("preferred-cabin")).click();
		WebElement EconomyClass = driver.findElement(By.xpath("//*[@id='preferred-cabin']/option[1]"));
		Thread.sleep(500);

		System.out.println(EconomyClass.getText());

		System.out.println("Traveler selected :" + EconomyClass.getAttribute("value") + "class option");

		Thread.sleep(1000);
		return this;

	}

	// BusinessOption
	public PhP_Flight VerifyBusinessCabin() throws InterruptedException {
		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='more-options__label']")).click();

		driver.findElement(By.id("preferred-cabin")).click();
		WebElement BusinessClass = driver.findElement(By.xpath("//*[@id='preferred-cabin']/option[2]"));
		Thread.sleep(500);

		System.out.println(BusinessClass.getText());

		System.out.println("Traveler selected :" + BusinessClass.getAttribute("value") + "class option");

		// assert.assertTrue(condition, message);

		Thread.sleep(2000);
		return this;
	}

	// FirstOption

	public PhP_Flight verifyFirstCabin() throws InterruptedException {
		// switch to default frame since "return" is selected by default
		WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		driver.switchTo().frame(travelstartIframe1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='more-options__label']")).click();

		driver.findElement(By.id("preferred-cabin")).click();
		WebElement FirstClass = driver.findElement(By.xpath("//*[@id='preferred-cabin']/option[3]"));
		Thread.sleep(500);

		System.out.println(FirstClass.getText());

		System.out.println("Traveler selected :" + FirstClass.getAttribute("value") + "class option");

		Thread.sleep(1000);
		return this;

	}
	
	public PhP_Flight DepartureCity() throws InterruptedException{
		//select departureCity
		driver.findElement(By.xpath("//input[starts-with(@id, 'airports-inline-orig')]")).sendKeys("Abidjan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@id, 'airports-inline-orig')]")).click();		
		/*WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));
		driver.switchTo().frame(travelstartIframe1);*/
		
		driver.switchTo().defaultContent();
		Thread.sleep(1 * 2000);
		return this;
		
		}
		
		//select destination City
		public PhP_Flight destCity() throws InterruptedException{
			WebElement travelstartIframe1 = driver
					.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));
		driver.findElement(By.xpath("//input[starts-with(@id, 'airports-inline-dest')]")).sendKeys("cdg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@id, 'airports-inline-dest')]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1 * 2000);
		return this;
		}
	
		//select depart date//MAKE IT DYNAMIC
		
		
		public PhP_Flight DepartDate() throws InterruptedException{
		driver.findElement(By.xpath("//span[starts-with(@id, 'depart-date-link')]")).click();
		Thread.sleep(1000);
		  
				  driver.findElement(By.xpath("//ts-search-depart-date[@class='floating-datepicker ng-scope ng-isolate-scope']"));

		  driver.findElement(By.cssSelector("button.datepicker__next-month")).click();
		  driver.findElement(By.xpath("//table[@class='table datepicker-table']"));
		  driver.findElement(By.xpath("//tbody/tr[3]/td[5]")).click();
		  WebElement travelstartIframe1 = driver
					.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));
		 
			Thread.sleep(1000);
		return this;	
		}
		
		

		//select traveler
		public PhP_Flight TravelerSelect() throws InterruptedException{
	// driver.findElement(By.xpath("//span[@id='add-traveller-link']")).click();	
	 driver.findElement(By.xpath("//div[@label='Adults']/button[@class='stepper--plus']")).click();
	 driver.findElement(By.xpath("//div[@label='Children']/button[@class='stepper--plus']")).click();
	 WebElement travelstartIframe1 = driver
				.findElement(By.xpath("//iframe[@id='travelstartIframe-dd7d2f33-38c3-4c69-baac-56d16157023b']"));

		Thread.sleep(1000);
		return this;
		}
		
		
		
		//search button
		public PhP_Flight ClickSearchBtn() throws InterruptedException{		
		driver.findElement(By.cssSelector("#search-for-flights-button > span")).click();		
		Thread.sleep(2000);
		
		System.out.println("the website title after clicking contains : " +  driver.getTitle());
		if (driver.getTitle().contains("Flight")) {//if the title still contain Flight, that means search wasn't successfull and an alert should show


		WebElement text = driver.findElement(By.xpath("//div[@class='alert alert--warning alert--warning-bg ng-scope']"));		
		//capture alert or error message	
		
			String alert = text.getText();
			//System.out.println(alert);
			
			   Assert.assertTrue(!driver.getTitle().contains("Flights"), (alert + ": User cannot proceed with the search"));
				 System.out.println( "browser navigate to next section");
			
			
	     }
		/*else {
			System.out.println("the website title after clicking contains : " +  driver.getTitle());


		if (!driver.getTitle().contains("Flight")) {
				System.out.println("the website title after clicking contains : " +  driver.getTitle());

				 Assert.assertTrue(!driver.getTitle().contains("Flights"), "Flight page. User cannot proceed with the search");
				 System.out.println("browser navigate to next section");
*/
			
			//}
		
		//}
		
		 return this;
		 
		}
}


// dropdown.getOptions();
// System.out.println(dropdown.getOptions());
// dropdown.selectByVisibleText("First");

// dropdown.getAllSelectedOptions();
// System.out.println(dropdown.getAllSelectedOptions());
// System.out.println();
// dropdown.selectByIndex(1);
// dropdown.selectByIndex(2);
// dropdown.selectByIndex(3);

// dropdown.selectByIndex(1);

// dropdown.toString();
// Thread.sleep(1000);
