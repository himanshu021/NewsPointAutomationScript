package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class sourceCaptionPagination extends BasetestNewsPoint {
	
	
	@Test
	public void getSourceCaption() throws Exception{
		
		try {
			
			clickName(newspointConstants.preferredLanText);
			clickId(newspointConstants.pickPublicationID);
			clickId(newspointConstants.firstCoachMarkID);
			//clickName(newspointConstants.proceedText);
			//clickId(newspointConstants.coachmarkID);
			clickId(newspointConstants.homeFirstNewsID);
			clickName(newspointConstants.secondCoachMarkText);
			
			
			/**
		     * Finding current date so that compare this date with what date coming with top news
		     */
			
			Date todaysDate = new Date();
			DateFormat df3 = new SimpleDateFormat("MMM d");
			String todaydate = df3.format(todaysDate);
	        System.out.println("Today Date is- " + todaydate);
	        
	        //String todaydate1= "Mar 16";
	        
	        BufferedWriter fw1= new BufferedWriter(new FileWriter("C:\\Users\\rajanikant.himanshu\\workspace\\NewsPaintApp\\results.txt",true));
	        fw1.newLine();
	        fw1.write("**************List of Tops news which are not updated as per today date ::  "   + todaydate);
			fw1.close();
			for(int i= 1; i<= 19 ; i++)
			{
			//if(!findElementById(newspointConstants.detailImageViewID).isDisplayed()){
				
				String compareText= findElementById(newspointConstants.differentNewsTextID).getText();
				System.out.println(compareText);
				
				if(compareText.equals("Newsroompost")){
				
				
					
					
					System.out.println("ID not found");
				
				    horizontalSwipe();
			
			}
			
			else{
				
				System.out.println("Id found");
				
				String title1= findElementById(newspointConstants.titleCaptionID).getText();
				System.out.println(title1);
				String sourceDetails= findElementById(newspointConstants.sourceCaptionID).getText();
				System.out.println(sourceDetails);
				
				if(sourceDetails.contains(todaydate)){
					
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
