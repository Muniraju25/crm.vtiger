package com.vtiger.createorganization;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.CreateOrganizationsPage;
import com.vtiger.objectrepository.Homepage;
import com.vtiger.objectrepository.OrganizationsInfoPage;
import com.vtiger.objectrepository.Organizationspage;



@Listeners(com.vtiger.genericutility.ListnerImp.class)
public class CreateOrgTest extends BaseClass{
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Exception{
		
	  	String orgName =eu.getData("Contact", 1, 2)+"_"+ju.getRandomNum();
 
		Homepage hp=new Homepage(driver);
		hp.getOrganizationsTab().click();
		
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrgButton().click();
	  
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.createOrganization(driver, orgName);
	    
	    OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	    if((oip.getOrgNameVerify().getText()).contains(orgName))
	    {
	    	System.out.println("organization is created===>pass");
	    }else{
	    	System.out.println("organization is not created===>fail");
	    }
	   
	}
	
}
