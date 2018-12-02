package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.custom.library.BasePage;

public class Account_Php extends BasePage{
	
	public Account_Php(){
		
	}
	
	/*public Account_Php waitUntilPageLoadComplete(){
		driver.findElement(By.className("page-heading"));
		
		return this;
	
	//li[@id='li_myaccount']

}*/
	
	
	
	
	public Account_Php VerifyAccountPage() {

		if (driver.getTitle().contains("Account")) {
			System.out.println("the website title after clicking 'LogIn' button contains : " + driver.getTitle());

			Assert.assertTrue(driver.getTitle().contains("Account"), ("Invalid Credentiels!"));

			System.out.println("LogIn successfull!");

		}

		else if (driver.getTitle().contains("Register")) {
			System.out.println("the website title after clicking 'Sign Up' buttons contains : " + driver.getTitle());
			WebElement text = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));

			String alert = text.getText();

			Assert.assertTrue(driver.getTitle().contains("Account"),
					(alert + ": user is not able to login-Invalid Credentiels"));

			System.out.println("Page title verified. user is able to login successfully");

		}

		return new Account_Php();

	}
	
	
	public LogInPage SignOut(){
		
		WebElement LogoutBtn= driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']/li[1]/ul/li[2]/a"));
		LogoutBtn.click();
				
			
			return new LogInPage();
		}

}


