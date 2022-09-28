package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.ProfileService;
import org.example.userfiles.UserProfile;

import java.util.List;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {


    private ProfileService profileService = new ProfileService();

    @GET
    public List<UserProfile> getProfile() {
        return profileService.getAllProfiles();
    }



    @POST
    public UserProfile addProfile(UserProfile profile) {
        return profileService.addProfile(profile);
    }

    @GET
    @Path("/{profileName}")
    public UserProfile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @PUT
    @Path("/{profileName}")
        public UserProfile updateProfile(@PathParam("profileName") String profileName, UserProfile profile ) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public UserProfile deleteProfile(@PathParam("profileName") String profileName){
     return profileService.removeProfile(profileName);
    }



}
