package com.clearlyrated.pages;
/**
 * class stires profile details
 */
public class ProfileData {
    private String name;
    private double highestRating;
    private int totalResponses;
    private boolean hasPhoto;
    private boolean hasRating;

    public ProfileData(String name, double highestRating, int totalResponses, boolean hasPhoto) {
        this.name = name;
        this.highestRating = highestRating;
        this.totalResponses = totalResponses;
        this.hasPhoto = hasPhoto;
       // this.hasRating = hasRating;
    }

    public String getName() 
    { 
    	return name; 
    }
    public double getHighestRating() 
    {
    return highestRating; 
    }
    public int getTotalResponses() 
    { 
    return totalResponses; 
    }
    public boolean hasPhoto() 
    { return hasPhoto; 
    }
    public boolean hasRating() 
    {
    return hasRating; 
    }

    @Override
    public String toString() 
    {
      return "Name: " + name + " | Rating: " + highestRating + " | Responses: " + totalResponses + " | Photo: " + hasPhoto + " | Rating Available: " + hasRating;
    }
}
