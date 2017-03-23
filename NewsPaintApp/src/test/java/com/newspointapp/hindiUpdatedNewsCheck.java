package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

public class hindiUpdatedNewsCheck extends BasetestNewsPoint{
	
	
	
	@Test
	public void hindiNewsCheck() throws Exception {
		
	     try{
			
			
			clickName(newspointConstants.hindiText);
			clickId(newspointConstants.pickPublicationID);
			clickId(newspointConstants.firstCoachMarkID);
			clickName(newspointConstants.myPublicationsText);
			clickId(newspointConstants.publicationSelectionID);
			clickName(newspointConstants.proceedLangSelectionText);
			clickId(newspointConstants.coachMarchAfterProceedID);
			clickId(newspointConstants.homeFirstNewsID);
			clickName(newspointConstants.secondCoachMarkText);
			
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
	        fw1.write("**************List of Tops news for HINDI which are not updated as per dates ::  "   + todaydate + " and " + ydate);
			fw1.close();
			for(int i= 1; i<= 20 ; i++)
			{
			if(!findElementById(newspointConstants.titleCaptionID).isEnabled()){
				
			
				
				
//				String compareText= findElementById(newspointConstants.differentNewsTextID).getText();
//				System.out.println(compareText);
				
//				if(compareText.equals("Newsroompost")){
				
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

}
