package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.custom.library.BasePage;

import pages.HomePagePhP;
import pages.LogInPage;

public class PhPLoginTest extends BasePage{
	
	
	
	@Test
	public void LoginT() throws Exception{
		
		
		new HomePagePhP().goto_PhPeWebsite().ClickAccountLogIn().VerifyLoginPage().User_LogIn("marieby@gmail.com", "shudelou07");
		

		
		
	}

}
