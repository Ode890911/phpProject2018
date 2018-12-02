package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.custom.library.BasePage;
import com.custom.library.ExcelManager;

//verify account creation multiple set of data
public class PhPSignUpTest extends BasePage {
	
	@DataProvider(name = "Sign Up")//data provider annotation to fetch the data from the external excel file
	public static Object[][] credentials() {
		ExcelManager reader = new ExcelManager("src/test/resources/PhpUserCredTest.xls");// create
																							
		return reader.getExcelData("Sheet1");
	}

	@Test(dataProvider = "Sign Up") // data provider annotation
	public void loginTest(String First_Name, String Last_Name, String Mobile_Number, String Email, String Password,
			String confirm_Password) throws InterruptedException {
		
		driver.get("http://www.phptravels.net");
		Thread.sleep(1 * 1000);
		// Get Title of a WebPage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sText = js.executeScript("return document.title;").toString();
		System.out.println("The website  title is  :" + sText);
		Thread.sleep(1 * 1000);
		
		//click 'Sign Up' 

		WebElement invisibleElem2 = driver.findElement(By.xpath("//*[@id='li_myaccount']/ul/li[2]/a"));
		js.executeScript("arguments[0].click();", invisibleElem2);
		
		
		
		
		
		//Verify Website title after navigating to Sign Up Page
		System.out.println("the website title after navigating to 'Sign Up' page contains : " +  driver.getTitle());
		Thread.sleep(1 * 1000);
		
		//Insert test data into the fields		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(First_Name);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Last_Name);		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Mobile_Number);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(confirm_Password);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("button.signupbtn.btn_full.btn.btn-action.btn-block.btn-lg")).click();
		Thread.sleep(1 * 1000);
		
		//if account creation successful, no alert// need validation
				

				if (driver.getTitle().contains("Account")) {
						System.out.println("the website title after clicking 'Sign Up' button contains : " +  driver.getTitle());

						Assert.assertTrue(driver.getTitle().contains("Account"), ("Account not created-Invalid Credentiels!") );			

						System.out.println("Sign up successfull!");

					
					}			

	
		else if (driver.getTitle().contains("Register")) {//if the title still contain register, that means sign up wasn't successfull and an alert should show
			System.out.println("the website title after clicking 'Sign Up' buttons contains : " +  driver.getTitle());
			driver.findElements(By.xpath("//div[@class='alert alert-danger']"));//after you click if there is an alert
			List<WebElement> text = driver.findElements(By.tagName("p"));//it will show as a list of webelement that we capture by tagname
			for (int i = 0; i < text.size(); i++) {//we loop through each alert and 
				String alert = text.get(i).getText();

				if (alert != null) {		

					System.out.println(alert);//and print the text
					Assert.assertTrue(driver.getTitle().contains("Account"), (alert + " Account not created-Invalid Credentiels!") );
					//System.out.println("Sign up successfull");
					
				}

			}
		}
		}
	
}

		

	



// Option 1: This is a good code

// List <WebElement> text = driver.findElements(By.xpath("//div[@class='alert
// alert-danger']"));

/*
 * for(int i=0; i< text.size(); i++) { if(text.get(i).getText() != null) {
 * System.out.println(text.get(i).getText()); } }
 */

// Option 2:
