package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

public class gujratiUpdatedNewsCheck extends BasetestNewsPoint{
	
	@Test
	public void gujraatiNewsCheck() throws Exception {
		
	     try{
			
			
			clickName(newspointConstants.gujratiText);
			clickId(newspointConstants.pickPublicationID);
			clickId(newspointConstants.firstCoachMarkID);
			clickName(newspointConstants.myPublicationsText);
			clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.proceedLangSelectionText);
			clickId(newspointConstants.coachMarchAfterProceedID);
			clickId(newspointConstants.homeFirstNewsID);
			clickName(newspointConstants.secondCoachMarkText);
			
			diferentPublicationCheck();
			
			navigateToBack();
			clickXpath(newspointConstants.settingXpath);
			clickName(newspointConstants.settingText);
			scrollTo(newspointConstants.settingSelectPublication);
			clickName(newspointConstants.settingSelectPublication);
			clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.gujratVishvaPublicationText);
			clickName(newspointConstants.proceedLangSelectionText);
			clickId(newspointConstants.homeFirstNewsID);
			diferentPublicationCheck();
			
			
			navigateToBack();
			clickXpath(newspointConstants.settingXpath);
			clickName(newspointConstants.settingText);
			scrollTo(newspointConstants.settingSelectPublication);
			clickName(newspointConstants.settingSelectPublication);
			//clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.gujratVishvaPublicationText);
			clickName(newspointConstants.gujratPradeshGujratiPublicationText);
			clickName(newspointConstants.proceedLangSelectionText);
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
	        
	        BufferedWriter fw1= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
	        fw1.newLine();
	        fw1.write("**************List of Tops news for Gujrati which are not updated as per dates ::  "   + todaydate + " and " + ydate);
			fw1.close();
			clickId(newspointConstants.homeFirstNewsID);
			diferentPublicationCheck();
			
			
			navigateToBack();
			clickXpath(newspointConstants.settingXpath);
			clickName(newspointConstants.settingText);
			scrollTo(newspointConstants.settingSelectPublication);
			clickName(newspointConstants.settingSelectPublication);
			//clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.gujratPradeshGujratiPublicationText);
			clickName(newspointConstants.gujratNavGujratSamayPublicationText);
			clickName(newspointConstants.proceedLangSelectionText);
			clickId(newspointConstants.homeFirstNewsID);
			diferentPublicationCheck();
			
		}
		
	    catch(Throwable e) {
			
			throw new Exception(e);
			
		       }
		
		

	}

}
