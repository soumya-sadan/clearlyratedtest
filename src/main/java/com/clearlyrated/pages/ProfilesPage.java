package com.clearlyrated.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author Soumya
 * extraxt details from profiles
 */

public class ProfilesPage {

	private WebDriver driver;

	private By allProfileCards = By.xpath(".//div[@class='profilepeople__card']");
	//private By allProfileCards = By.xpath("//div[@class='card card--raised card--recruiters']//div[@class='profilepeople']//div[@class='profilepeople__card']");
	
	

	public ProfilesPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getProfiles() {
		 //By allProfileCards = By.xpath(".//div[@class='profilepeople__card']");
		List<WebElement> allProfiles = driver.findElements(allProfileCards);
		return allProfiles;
	}

	public String getName(WebElement profile) {
		String name = profile.findElement(By.xpath(".//a[@class='profilepeople__name--link']")).getText().trim();

		// a[@class='profilepeople__name--link']
		System.out.println("Name : " + name);
		return name;
	}

	@SuppressWarnings("deprecation")
	public double getHighestStarRating(WebElement profile) {
		
			
		List<WebElement> allRatingText = profile.findElements(By
			    .xpath(".//div[@class='profilepeople-stars__text']/span[@class='profilepeople-stars__text--bold']"));
		
		
				System.out.println(allRatingText.size());		

		double highestRating = 0.0;

		for (WebElement rating : allRatingText) {
			String ratingText = rating.getText().trim(); // 4.9 star
			//System.out.println("Rating text: >>>testing >> " + ratingText);
			// String ratings = ratingText.split(" ")[0];
			//double ratings = Double.parseDouble(ratingText.split(" ")[0]);
			//System.out.println("Final Ratings  ****** : " + ratings);
			
			Pattern pattern = Pattern.compile("(\\d+\\.\\d+) star");
			Matcher matcher = pattern.matcher(ratingText);
			double rating1 = 0.0;

			if (matcher.find()) {
			    rating1 = Double.parseDouble(matcher.group(1));
			    System.out.println("Extracted Rating: " + rating1);
			}

			if (rating1 > highestRating) {
				highestRating = rating1;
			}			
		}
		
	
		
		System.out.println("highest Ratings for user " + getName(profile) + "  is :  " +highestRating);
		return highestRating;
	}
	
	public int getHighestResponse(WebElement profile) {
		
		//div[@class='profilepeople-stars__text']/span[@class='profilepeople-stars__text--bold'][2]
		
		List<WebElement> responseElement = profile.findElements(By
				.xpath(".//span[contains(text(), 'verified')]"));
		int totalResponse = 0;
		for (WebElement response : responseElement) {
		String responseText = response.getText(); // 4.9 star
		String[] words = responseText.split(" "); // 4.9
		int starRating =Integer.parseInt(words[0]);
		
		totalResponse = totalResponse + starRating; //adding all respnsnes
		//System.out.println("Total Resposne >>>  : " + totalResponse);
	      }
	System.out.println("Total Resposne  ****** : " + totalResponse);
	  	return totalResponse;

     }
	
	
    public boolean hasPhoto(WebElement profile) {
    	
    	boolean hasPhoto = !profile.findElements(By.xpath(".//a[@class='profilepeople__image--link']")).isEmpty();
	//	System.out.println("Has photo for " + hasPhoto);
		
        return hasPhoto;
    }
    
    public List<ProfileData> extractProfileData() {
        List<WebElement> profiles = getProfiles();
        //System.out.println(profiles);
       System.out.println( profiles.size());
        
        List<ProfileData> profileList = new ArrayList<>();
        for (WebElement profile : profiles) 
        {
           // profileList.add(new ProfileData( getName(profile),getHighestStarRating(profile),getHighestResponse(profile),hasPhoto(profile) ));
            
           
        		String name = getName(profile);
        		double rating =getHighestStarRating(profile);
        		int responses = getHighestResponse(profile);
        		boolean hasPhoto = hasPhoto(profile);
        		profileList.add(new ProfileData(name, rating, responses, hasPhoto));
        		System.out.println("=========== PROFILE INFO ===================");
        	System.out.println("Name: " + name + "  Rating :" + rating + "  Responses : " + responses + "  Is there photo : " + hasPhoto);
        	}   
            
        
        return profileList;
    }
    
    
    
}