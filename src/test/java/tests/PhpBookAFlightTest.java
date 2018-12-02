package tests;

import org.testng.annotations.Test;

import com.custom.library.BasePage;

import pages.HomePagePhP;

public class PhpBookAFlightTest  extends BasePage{
	
	@Test
	public void OneWayFlight() throws Exception{
		
		
		//new HomePagePhP().goto_PhPeWebsite().ClickFlightLink().OneWayOption().DepartureCity().destCity().DepartDate().TravelerSelect().ClickSearchBtn();
	//	new HomePagePhP().goto_PhPeWebsite().ClickFlightLink().OneWayOption().DepartureCity().destCity();
		new HomePagePhP().goto_PhPeWebsite().Hotel_Search();

	

		
		
	}
}