package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

public class bengoliUpdatedNewsCheck extends BasetestNewsPoint{
	
	
	@Test
	public void bengoliNewsCheck() throws Exception {
		
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
	    	 
	    	 
			clickName(newspointConstants.begoliText);
			clickId(newspointConstants.pickPublicationID);
			clickId(newspointConstants.firstCoachMarkID);
			clickName(newspointConstants.myPublicationsText);
			clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.proceedLangSelectionText);
			clickId(newspointConstants.coachMarchAfterProceedID);

	        BufferedWriter fw2= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
	        fw2.newLine();
	        fw2.write("*** Bengali - Pradesh 18 / Top News / Content Freshness for dates ::  "   + todaydate + " and " + ydate + "***");
	        fw2.newLine();
	        fw2.close();
			
			clickId(newspointConstants.homeFirstNewsID);
			clickId(newspointConstants.secondCoachMarkID);
			
			diferentPublicationCheck();
			
			String title1= findElementById(newspointConstants.titleCaptionID).getText();
			System.out.println(title1 );
			String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
			System.out.println(sourceDetails );
			
			if(sourceDetails.contains(todaydate)|| sourceDetails.contains(ydate)){
				
            	BufferedWriter fw3= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
            	fw3.newLine();
            	fw3.write("No stale data found for above publication.");
            	fw3.newLine();
            	fw3.close();
		
		
	}
			
			navigateToBack();
			clickXpath(newspointConstants.settingXpath);
			clickName(newspointConstants.settingText);
			scrollTo(newspointConstants.settingSelectPublication);
			clickName(newspointConstants.settingSelectPublication);
			clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.bbcPublicationText);
			clickName(newspointConstants.proceedLangSelectionText);
			
	        
	        
	        //String todaydate1= "Mar 18";
	       // String ytodaydate1= "Mar 17";
	        
	        BufferedWriter fw1= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
	        fw1.newLine();
	        fw1.write("*** Bengali - BBC Bengali / Top News / Content Freshness for dates :: "   + todaydate + " and " + ydate + "***");
	        fw1.newLine();
	        fw1.close();
			
			clickId(newspointConstants.homeFirstNewsID);
			diferentPublicationCheck();
			
			String title2= findElementById(newspointConstants.titleCaptionID).getText();
			System.out.println(title2 );
			String sourceDetails1= findElementById(newspointConstants.sourceCaptionID).getText();
			System.out.println(sourceDetails1 );
			
			
			if(sourceDetails1.contains(todaydate)|| sourceDetails1.contains(ydate)){
				
            	BufferedWriter fw3= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
            	fw3.newLine();
            	fw3.write("No stale data found for above publication.");
            	fw3.newLine();
            	fw3.close();
		
		
	}
			
			// Selecting eSamay publication
			
			navigateToBack();
			clickXpath(newspointConstants.settingXpath);
			clickName(newspointConstants.settingText);
			scrollTo(newspointConstants.settingSelectPublication);
			clickName(newspointConstants.settingSelectPublication);
			//clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.bbcPublicationText);
			clickName(newspointConstants.eSamayPublicationText);
			clickName(newspointConstants.proceedLangSelectionText);
			BufferedWriter fw= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
	        fw.newLine();
	        fw.write("*** Bengali - E-Samay / Top News / Content Freshness for dates ::  "   + todaydate + " and " + ydate + "***");
	        fw.newLine();
	        fw.close();
			clickId(newspointConstants.homeFirstNewsID);
			diferentPublicationCheck();
			String title3= findElementById(newspointConstants.titleCaptionID).getText();
			System.out.println(title3 );
			String sourceDetails2= findElementById(newspointConstants.sourceCaptionID).getText();
			System.out.println(sourceDetails2 );
			if(sourceDetails2.contains(todaydate)|| sourceDetails2.contains(ydate)){
				
            	BufferedWriter fw3= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
            	fw3.newLine();
            	fw3.write("No stale data found for above publication.");
            	fw3.newLine();
            	fw3.close();
		
		
	}
			
		}
		
	    catch(Throwable e) {
			
			throw new Exception(e);
			
		       }
		
		

	}

}
