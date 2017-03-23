package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

public class verticalSwipeScreen extends BasetestNewsPoint   {
	
	@Test
	public void screenPaginationCall() throws Exception{
		
		try{
			
			clickName(newspointConstants.preferredLanText);
			clickId(newspointConstants.pickPublicationID);
			clickId(newspointConstants.firstCoachMarkID);
			//clickName(newspointConstants.proceedText);
			//clickId(newspointConstants.coachmarkID);
			//clickId(newspointConstants.homeFirstNewsID);
			//clickName(newspointConstants.secondCoachMarkText);
			int j= 0;
			for(j=0 ; j<=1; j++){
			verticalSwipe();
			}
			System.out.println("1st scroll done");
			clickId(newspointConstants.homeFirstNewsID);
			clickName(newspointConstants.secondCoachMarkText);
			//String newsCoutFetched= findByName(newspointConstants.newsountText).getText();
			//System.out.println(newsCoutFetched);
			
			
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
	        fw1.write("***List of Tops news which are not updated as per dates (Across Publications)::  "   + todaydate + " and " + ydate + "****");
			fw1.close();
			
//			String title1= findElementById(newspointConstants.titleCaptionID).getText();
//			System.out.println(title1);
//			String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
//			System.out.println(sourceDetails);
			for(int i= 1; i<= 39 ; i++)
			{
			if(!findElementById(newspointConstants.titleCaptionID).isEnabled()){
				
			
				
				
//				String compareText= findElementById(newspointConstants.differentNewsTextID).getText();
//				System.out.println(compareText);
				
//				if(compareText.equals("Newsroompost")){
				
				          System.out.println("ID not found");
//				          String title1= findElementById(newspointConstants.titleCaptionID).getText();
//							System.out.println(title1);
//							String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
//							System.out.println(sourceDetails);
//				            BufferedWriter fw= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
//							fw.newLine();
//							fw.write(title1);
//							fw.write(" ->>> ");
//							fw.write(  sourceDetails);
//							fw.newLine();
//							fw.close();
				
				          horizontalSwipe();
			
			}
			
			else{
				
				System.out.println("Id found");
				
				String title1= findElementById(newspointConstants.titleCaptionID).getText();
				System.out.println(title1);
				String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
				System.out.println(sourceDetails);
				
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
			
			String title1= findElementById(newspointConstants.titleCaptionID).getText();
			System.out.println(title1);
			String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
			System.out.println(sourceDetails);
				
          if(sourceDetails.contains(todaydate)|| sourceDetails.contains(ydate)){
				
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
