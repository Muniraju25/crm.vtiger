package com.vtiger.createcontact;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.ContactInfoPage;
import com.vtiger.objectrepository.Contactspage;
import com.vtiger.objectrepository.CreateContactpage;
import com.vtiger.objectrepository.Homepage;


@Listeners(com.vtiger.genericutility.ListnerImp.class)
public class CreateContactTest extends BaseClass {
	 @Test(groups = "smokeTest")
     public void createContactTest()throws Exception
     {	
 	  	//Initialize the variables
     	String lastName=eu.getData("Contact", 1, 3)+"_"+ju.getRandomNum();
 
 		//Navigate to Contacts 
 		Homepage hp=new Homepage(driver);
 		hp.getContactsTab().click();
 	
 		//click on create contact in contacts page
 		 Contactspage cp= new Contactspage(driver);
  	    cp.getCreateContactButton().click();
  	    
  	    //Enter the lastname and perform click on action on lookup
  	    CreateContactpage ccp=new CreateContactpage(driver);
  	    ccp.getLastNametxtfd().sendKeys(lastName);
  	    ccp.getSaveButton().click();
  	    
  	    //Verify
  	    ContactInfoPage cip=new ContactInfoPage(driver);
  	    if((cip.getConNameVerify().getText()).contains(lastName))
  	    {
  	    	System.out.println(lastName+" is created===>pass");
  	    }else{
  	    	System.out.println(lastName+" is not created===>fail");
  	    }
  	    
     }
	 
}
