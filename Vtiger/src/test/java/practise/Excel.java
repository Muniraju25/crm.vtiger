package practise;

import org.testng.annotations.Test;

import com.vtiger.genericutility.ExcelUtility;

public class Excel {
   @Test
   public void data()
   {
	   ExcelUtility eu=new ExcelUtility();
	   
	   String orgName =eu.getData("Contact", 1, 2);
   	String lastName=eu.getData("Contact", 1, 3);
   	String indName=eu.getData("Sheet1", 1, 3);
   	String typeName=eu.getData("Sheet1", 1, 4);
   	System.out.println(orgName);
   	System.out.println(lastName);
   	System.out.println(indName);
   	System.out.println(typeName);
   	
   }
}
