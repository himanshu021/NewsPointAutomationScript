package com.newspointapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateToStringDemo{
   public static void main(String args[])
   {
       Date todaysDate = new Date();
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       DateFormat df3 = new SimpleDateFormat("MMM d");
       DateFormat df4 = new SimpleDateFormat("MM dd, yyyy");
       DateFormat df5 = new SimpleDateFormat("E, MMM dd yyyy");
       DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
       try
       {
           //format() method Formats a Date into a date/time string. 
           String testDateString = df.format(todaysDate);
           System.out.println("String in dd/MM/yyyy format is: " + testDateString);
           String str2 = df2.format(todaysDate);
           System.out.println("String in dd-MM-yyyy HH:mm:ss format is: " + str2);
           String str3 = df3.format(todaysDate);
           System.out.println("String in dd-MMM-yyyy format is: " + str3);
           String str4 = df4.format(todaysDate);
           System.out.println("String in MM dd, yyyy format is: " + str4);
           String str5 = df5.format(todaysDate);
           System.out.println("String in E, MMM dd yyyy format is: " + str5);
           String str6 = df6.format(todaysDate);
           System.out.println("String in E, E, MMM dd yyyy HH:mm:ss format is: " + str6);
           
           System.out.println(str3);
           
           String str11= "Mar 9";
           
           if (str3.equals(str11)){
        	   
        	   System.out.println("Himanshu: Date is for today");
        	   
           }
           
           else{
        	   String title= "फ्रांसच्या'कान्स फिल्म' फेस्टिवलमध्ये 'धागा' लघुपट";
        	   System.out.println(title);
           }
           String str22= "India TV | Mar 6, 2017, 10.58AM IST";
           if(str22.contains(str11)){
        	   
        	   System.out.println("Himanshu mil gaya");
        	   
        	   
           }
           else{
        	   
        	  // System.out.println("nahin mila");
        	   System.out.println("Nahin mila for:" + str22);
           }

       }
       catch (Exception ex ){
          System.out.println(ex);
       }
    }
}