package org.example.database;


import org.example.userfiles.UserComment;
import org.example.userfiles.UserMessage;
import org.example.userfiles.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Long, UserMessage> messages = new HashMap<>();
    private static Map<String, UserProfile> profiles = new HashMap<>();


    public static Map<Long, UserMessage> getMessages() {
        return messages;
    }

    public static Map<String, UserProfile> getProfiles() {
        return profiles;
    }


}
