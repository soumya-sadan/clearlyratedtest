package com.clearlyrated.tests;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clearlyrated.base.BaseTest;
import com.clearlyrated.pages.ProfileData;
import com.clearlyrated.pages.ProfileSorter;
import com.clearlyrated.pages.ProfilesPage;


public class ProfileTest extends BaseTest {
	
	
	
	@Test
	public void testProfileSorting()
	{
	//driver.get("https://www.clearlyrated.com/staffing/md-usa/hanover-md/actalent-hanover-md");
		System.out.println("started........");
	//ProfilesPage profilePage = new ProfilesPage(driver);
	System.out.println("hiiii");
	List<ProfileData> profileList = profilePage.extractProfileData();
	
	//List<WebElement> profiles = profilePage.getProfiles(); // retrieve profile cards
	//List<ProfileData> profileList = new ArrayList<>();
	
	//List<WebElement> names = driver.findElements(By.xpath("//div[@class='profilepeople__collection']//div[@class='profilepeople__name']"));
	
	
	System.out.println("No. of profiles fetched : " + profileList.size());
	
	List<ProfileData> sortedProfiles = ProfileSorter.sortProfiles(profileList);
	
	System.out.println("-----------");
	
//	System.out.println("people order fetched form site :");
  //  for (ProfileData p : sortedProfiles) {
    //    System.out.println(p.getName());
   // }
    System.out.println("---end====" );
	
    System.out.println("Extracted Profile List: " + profileList);
    System.out.println("Expected Sorted List: " + sortedProfiles);
    
 // Validate sorting order
	
    Assert.assertEquals(profileList, sortedProfiles, "Profiles are not sorted correctly.");
    System.out.println("Completed----------");
	
	}//end method 
	
}//end class