package org.example.service;

import org.example.database.DatabaseClass;
import org.example.userfiles.UserMessage;
import org.example.userfiles.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

   private Map<String, UserProfile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
       profiles.put("ye", new UserProfile(1L, "ye", "Kanye", "West"));
    }

    public List<UserProfile> getAllProfiles() {
       return new ArrayList<UserProfile>(profiles.values());
   }

   public UserProfile getProfile(String profileName){
       return profiles.get(profileName);
   }

    public UserProfile addProfile(UserProfile profile) {
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public UserProfile updateProfile(UserProfile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }

    public UserProfile removeProfile(String profileName){
        return profiles.remove(profileName);
    }


}
