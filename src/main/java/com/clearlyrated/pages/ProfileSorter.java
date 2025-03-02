package com.clearlyrated.pages;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.clearlyrated.pages.ProfileData;

public class ProfileSorter {

    public static List<ProfileData> sortProfiles(List<ProfileData> profileList) {
        List<ProfileData> withPhotoWithRatings = new ArrayList<>();
        List<ProfileData>withoutPhotoWithRatings = new ArrayList<>();
        List<ProfileData>withPhotoWithoutRatings = new ArrayList<>();
        List<ProfileData> withoutPhoto = new ArrayList<>();

        for (ProfileData prof : profileList) {
            if (prof.hasPhoto() && prof.getHighestRating() > 0) {
                withPhotoWithRatings.add(prof);
            } else if (!prof.hasPhoto() && prof.getHighestRating() > 0) {
                withoutPhotoWithRatings.add(prof);}
            else if (prof.hasPhoto() && prof.getHighestRating() == 0) {
            	withPhotoWithoutRatings.add(prof);}
              else {
                withoutPhoto.add(prof);
            }
        }
        
        

        withPhotoWithRatings.sort(Comparator.comparing(ProfileData::getHighestRating).reversed()
                .thenComparing(ProfileData::getTotalResponses, Comparator.reverseOrder()) 
                .thenComparing(ProfileData::getName)); 
        
       // withPhotoWithoutRatings.sort(Comparator.comparing(ProfileData::getName));
        
        withoutPhotoWithRatings.sort(Comparator.comparing(ProfileData::getHighestRating).reversed()
                .thenComparing(ProfileData::getTotalResponses, Comparator.reverseOrder()) 
                .thenComparing(ProfileData::getName)); 
        
        withPhotoWithoutRatings.sort(Comparator.comparing(ProfileData::getName));
        
        withoutPhoto.sort(Comparator.comparing(ProfileData::getHighestRating).reversed()
                .thenComparing(ProfileData::getTotalResponses, Comparator.reverseOrder()) 
                .thenComparing(ProfileData::getName));
        
        
       // withoutPhotoWithRatings.sort(Comparator.comparing(ProfileData::getHighestRating).reversed()
         //       .thenComparing(ProfileData::getTotalResponses, Comparator.reverseOrder())
          //      .thenComparing(ProfileData::getName));

        // 3️⃣ Profiles with Photos but No Ratings → Sort Alphabetically
       

       
     //   withoutPhoto.sort(Comparator.comparing(ProfileData::getName));
        
        
        for(ProfileData p: withPhotoWithRatings)
        {
        	System.out.println("WITH photo WITH ratings : " + p.getName());
        }
        
        for(ProfileData p4: withoutPhotoWithRatings)
        {
        	System.out.println("without photo WITH ratings : " + p4.getName());
        }
        
        for(ProfileData p2:  withoutPhoto)
        {
        	System.out.println("without photo : " + p2.getName());
        }
        
        for(ProfileData p1:  withPhotoWithoutRatings)
        {
        	System.out.println("WITH photo without ratings : " + p1.getName());
        }

        List<ProfileData> sortedProfiles = new ArrayList<>();
        sortedProfiles.addAll(withPhotoWithRatings);
        sortedProfiles.addAll(withoutPhotoWithRatings);
        sortedProfiles.addAll(withoutPhoto);
        sortedProfiles.addAll(withPhotoWithoutRatings);
        
       
        
       // sortedProfiles.addAll(withPhotoWithoutRatings);
    
        
       
    
       
                System.out.println("People in sorted order after applying sorting logic: ");
        for(ProfileData p : sortedProfiles)
        {
        	 System.out.print(" " + p.getName()); 
        } 

        return sortedProfiles;
    }
}
