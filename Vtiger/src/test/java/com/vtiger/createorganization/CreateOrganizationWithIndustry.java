package com.vtiger.createorganization;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;
import com.vtiger.objectrepository.CreateOrganizationsPage;
import com.vtiger.objectrepository.Homepage;
import com.vtiger.objectrepository.OrganizationsInfoPage;
import com.vtiger.objectrepository.Organizationspage;

@Listeners(com.vtiger.genericutility.ListnerImp.class)
public class CreateOrganizationWithIndustry extends BaseClass {
	@Test(groups = "regressionTest")
	  public void createOrgWithIndustriesTest()throws Exception
	  {
	  	
		//Read test data
	  	String orgName =eu.getData("Contact", 1, 2)+"_"+ju.getRandomNum();
 	    String indName=eu.getData("Sheet1", 1, 3);
 	    String typeName=eu.getData("Sheet1", 1, 4);
		
		//Navigate to Organizations 
		Homepage hp=new Homepage(driver);
		hp.getOrganizationsTab().click();
		
		//Navigate to Create Organization 
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrgButton().click();
		
		//Navigate to Create Organization 
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.createOrganization(driver, orgName, indName, typeName);
		
	   // Verify
	    OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	    if((oip.getOrgNameVerify().getText()).contains(orgName))
	    {
	    	System.out.println("organization is created===>pass");
	    }else{
	    	System.out.println("organization is not created===>fail");
	    }
	    
	    if((oip.getIndInfo().getText()).equals(indName))
	    {
	    	System.out.println(indName+" is created ===>PASS");
	    }else{
	    	System.err.println(indName+" is not created===>FAIL");
	    }
	    
	    if((oip.getTypeInfo().getText()).equals(typeName))
	    {
	    	System.out.println(typeName+" is created ===>PASS");
	    }else{
	    	System.out.println(typeName+" is not created ===>PASS");
	    }
	  
		}
}
