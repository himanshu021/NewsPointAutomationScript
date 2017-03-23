package com.newspointapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

public class maraathiLangCheck extends BasetestNewsPoint{
	
	
	
	
	
	
	
@Test
public void langMarathiCheck() throws Exception {
	
     try{
		
		
		clickName(newspointConstants.maraathiText);
		clickId(newspointConstants.pickPublicationID);
		clickId(newspointConstants.firstCoachMarkID);
		//clickXpath(newspointConstants.settingXpath);
		clickName(newspointConstants.myPublicationsText);
		clickId(newspointConstants.publicationSelectionID);
		clickName(newspointConstants.proceedLangSelectionText);
		clickId(newspointConstants.coachMarchAfterProceedID);
		clickId(newspointConstants.homeFirstNewsID);
		clickId(newspointConstants.secondCoachMarkID);
		
		
		diferentPublicationCheck();
		navigateToBack();
		clickXpath(newspointConstants.settingXpath);
		clickName(newspointConstants.settingText);
		scrollTo(newspointConstants.settingSelectPublication);
		clickName(newspointConstants.settingSelectPublication);
		clickId(newspointConstants.publicationSelectionID);
		clickName(newspointConstants.publicationMaharastraTimesText);
		clickName(newspointConstants.proceedLangSelectionText);
		clickId(newspointConstants.homeFirstNewsID);
		diferentPublicationCheck();
		
	}
	
    catch(Throwable e) {
		
		throw new Exception(e);
		
	       }
	
	

}
}
