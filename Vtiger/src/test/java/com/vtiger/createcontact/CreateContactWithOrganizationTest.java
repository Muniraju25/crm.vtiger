package com.vtiger.createcontact;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.ContactInfoPage;
import com.vtiger.objectrepository.Contactspage;
import com.vtiger.objectrepository.CreateContactpage;
import com.vtiger.objectrepository.CreateOrganizationsPage;
import com.vtiger.objectrepository.Homepage;
import com.vtiger.objectrepository.OrganizationsInfoPage;
import com.vtiger.objectrepository.Organizationspage;

@Listeners(com.vtiger.genericutility.ListnerImp.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	@Test(groups = "regressionTest")
    public void createContactWithOrgTest()
    {
   	
    	//Read test data
    	String orgName =eu.getData("Contact", 1, 2)+"_"+ju.getRandomNum();
    	String lastName=eu.getData("Contact", 1, 3)+"_"+ju.getRandomNum();
    	String indName=eu.getData("Sheet1", 1, 3);
    	String typeName=eu.getData("Sheet1", 1, 4);
    	
		//Navigate to Organizations 
		Homepage hp=new Homepage(driver);
		hp.getOrganizationsTab().click();
		
		//Navigate to Create Organization 
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrgButton().click();
		
		//Create organization
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.createOrganization(driver, orgName, indName, typeName);
	    
	    //Verify
	    OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	    if((oip.getOrgNameVerify().getText()).contains(orgName))
	    {
	    	System.out.println("organization is created===>pass");
	    }else{
	    	System.err.println("organization is not created===>fail");
	    }
	    
	    //wait for element visiblity
	    wu.waitForElementVisibility(driver, hp.getContactsTab());
	    //Navigate to Contacts
	    hp.getContactsTab().click();
	    Contactspage cp= new Contactspage(driver);
       
	    //Navigate to create contact
	    cp.getCreateContactButton().click();
	    
	    //Create a contact
	    CreateContactpage ccp=new CreateContactpage(driver);
	    ccp.createContact(driver, lastName, orgName);
	    
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
