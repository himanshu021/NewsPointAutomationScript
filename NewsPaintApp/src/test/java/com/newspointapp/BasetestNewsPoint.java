package com.newspointapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public abstract class BasetestNewsPoint {
	
	protected AndroidDriver driver= null;
	protected MobileElement element;
	WebDriverWait wait;
	
	public boolean isEnabled() {
		return true;
	}
	
	public MobileElement findElementByClassName(String className) {
		return (MobileElement) driver.findElement(By.className(className));
	}

	public MobileElement findElementById(String id) {
		return (MobileElement) driver.findElement(By.id(id));
	}

	public MobileElement findByName(String name) {
		return (MobileElement) driver.findElement(By.name(name));
	}
	public MobileElement findByXpath(String xpath){
		return (MobileElement) driver.findElement(By.xpath(xpath));
	}

	public void clickClassName(String className) {
		findElementByClassName(className).click();
	}
	

	public void clickName(String name) {
		findByName(name).click();
	}

	public void clickId(String id) {
		findElementById(id).click();
	}
	
	public void clickXpath(String xpath){
		findByXpath(xpath).click();
	}
	public void sendKeysForID(String id, String keyword){
		findElementById(id).sendKeys(keyword);
	}
	public void sendKeysForName(String name, String keyword){
		findByName(name).sendKeys(keyword);
	}
	public void sendKeysForXpath(String xpath, String keyword){
		findByXpath(xpath).sendKeys(keyword);
	}
	
	
	public void scrollTo(String scrolltextname) {
		driver.scrollToExact(scrolltextname);
	}

	public void scrollToClick(String scrolltextname) {
		driver.scrollToExact(scrolltextname).click();
	}

	public void navigateToBack() {
		driver.navigate().back();
	}

//	public void backButton() {
//		driver.findElement(
//				By.className(RetailerConstants.BackButton_Clasaname))
//				.click();
//	}
	
	public void screenSwipeWithAXS(int x, int y, int z, int a, int b) {
		driver.swipe(x, y, z, a, b);
	}
	
	public void hideKeyboard() {
		
		driver.hideKeyboard();
		
	}
	
	public void horizontalSwipe() throws Exception{
		
		try{
		
		Dimension size= driver.manage().window().getSize();
		//System.out.println(size);
		//Find swipe start and end point from screen's with and height.
	    //Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.90);
		//Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.10);
		//Find vertical point where you wants to swipe. It is in middle of screen height.
		int starty = size.height / 2;
		//System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		 //Swipe from Right to Left.
		  driver.swipe(startx, starty, endx, starty, 1000);
		  Thread.sleep(2000);
		}
		
              catch(Throwable e) {
			
			throw new Exception(e);
			
		       }
	}
	
public void verticalSwipe() throws Exception{
		
		try{
		
			
			//Get the size of screen.
			Dimension size = driver.manage().window().getSize();
			
			   
			  //Find swipe start and end point from screen's with and height.
			  //Find starty point which is at bottom side of screen.
			  int starty = (int) (size.height * 0.80);
			  //Find endy point which is at top side of screen.
			  int endy = (int) (size.height * 0.20);
			  //Find horizontal point where you wants to swipe. It is in middle of screen width.
			  int startx = size.width / 2;
			  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

			  //Swipe from Bottom to Top.
			  driver.swipe(startx, starty, startx, endy, 1000);
			  Thread.sleep(5000);
			  //Swipe from Top to Bottom.
			  driver.swipe(startx, endy, startx, starty, 1000);
			  Thread.sleep(5000);
		}
		
              catch(Throwable e) {
			
			throw new Exception(e);
			
		       }
	}
	
public void diferentPublicationCheck() throws Exception{
	
	try{
		/**
	     * Finding current date so that compare this date with what date coming with top news
	     */
		
		Date todaysDate = new Date();
		DateFormat df3 = new SimpleDateFormat("MMM d");
		String todaydate = df3.format(todaysDate);
		//String yesterdayDate= df3.format(todaysDate);
        System.out.println("Today Date is- " + todaydate);
        
        Date yDate = DateUtils.addDays(new Date(), -1);
        DateFormat sdf = new SimpleDateFormat("MMM d");
        String ydate= sdf.format(yDate);
        System.out.println("Yesterday date is-  " + ydate);
        
        
        //String todaydate1= "Mar 18";
       // String ytodaydate1= "Mar 17";
        
//        BufferedWriter fw1= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
//        fw1.newLine();
//        //fw1.write("**************List of Tops news for MARAATHI which are not updated as per dates ::  "   + todaydate + " and " + ydate);
//		fw1.close();
		for(int i= 1; i<= 1 ; i++)
		{
		if(!findElementById(newspointConstants.titleCaptionID).isEnabled()){
			
		
			
			
//			String compareText= findElementById(newspointConstants.differentNewsTextID).getText();
//			System.out.println(compareText);
			
//			if(compareText.equals("Newsroompost")){
			
			          System.out.println("ID not found");		         
			
			          horizontalSwipe();
		
		}
		
		else{
			
			System.out.println("Id found");
			//String asm = "\u09ae\u0987 \u0985\u09b8\u09aE\u09c0\u09df\u09be \u09b6\u09ac\u09cd\u09a6";
			String title1= findElementById(newspointConstants.titleCaptionID).getText();
			System.out.println(title1);
			String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
			System.out.println(sourceDetails );
			
			if(sourceDetails.contains(todaydate)|| sourceDetails.contains(ydate)){
				
				horizontalSwipe();
				
			}
			
			else{
				
				BufferedWriter fw= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
				fw.newLine();
				fw.write(title1);
				fw.write(" ->>> ");
				fw.write(  sourceDetails);
				fw.newLine();
				
				fw.close();
				horizontalSwipe();
				
			}
			
			  
			}
			
		}
		
		
	}
	catch(Throwable e) {
		
		throw new Exception(e);
		
	       }	
	
}

	
	public void waiting(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	@BeforeTest
	  public void intializeDrivers() 
	  
	  {
		  
		  // For Consumer App
		 File appdir= new File("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\APK");
		  File app= new File(appdir,"com.til.timesnews_3.0.1.apk");
		  DesiredCapabilities cap= new DesiredCapabilities();
		 // cap.setCapability(CapabilityType.BROWSER_NAME, "");
		  cap.setCapability("platformname","Android");
		  cap.setCapability("deviceName", "Nexus 5");
		  cap.setCapability("platformVersion","4.4.4");
		  cap.setCapability("app-package", "com.til.timesnews");
		  cap.setCapability("app-activity", "");
		  cap.setCapability("unicodekeyboard", true);
		  cap.setCapability("resetkeyboard", true);
		  cap.setCapability("app", app.getAbsolutePath());
		  try{
			  driver= new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), cap);  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
		  wait = new WebDriverWait(driver, 60);
		 
		  
	  }

	  @AfterTest
	  public void killDriver() 
	  
	  {
		  
		driver.quit();
	  }

	
	



}
