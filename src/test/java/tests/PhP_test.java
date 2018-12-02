package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.custom.library.BasePage;

import pages.HomePagePhP;
import pages.PhP_Flight;

public class PhP_test extends BasePage{
	final static Logger logger = Logger.getLogger(HomePagePhP.class);
	HomePagePhP myTravelHpage = new HomePagePhP();
//	LogIn UserLog = new LogIn();
	//VerifyCurrency MyCurrency= new VerifyCurrency();
	//PhP_Flight MyFlight = new PhP_Flight();
	//OneWayFlight MyTrip = new OneWayFlight();
	PhP_Flight MyFlight = new PhP_Flight();
	
	
	
	@Test
	public void LogIn() throws Exception{
		//Actions action = new Actions(driver);

		myTravelHpage.goto_PhPeWebsite();
		//myTravelHpage.VerifyCurrency();
		
	//	myTravelHpage.VerifyLogo();
		
		//myTravelHpage.Reserv_Details();
	//	UserLog.User_LogIn();
		//MyCurrency.CurrencyDropDown();
		//MyFlight.Flight_Reser();
		//MyTrip.BookAFlight();
		//myTravelHpage.BookAFlight();
		myTravelHpage.ClickFlightLink();
		MyFlight.OneWayOption();
	//	MyFlight.MultiCityAddFlight();
		//MyFlight.cabinOptionList();
		//MyFlight.MultiCityOption();
		MyFlight.TwoWayOption();
		
		
		//MyFlight.VerifyFlightPage();
	//	myTravelHpage.ClickToursLink();
		//myTravelHpage.ClickCarsLink();

		
	}
	

}
