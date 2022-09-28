package org.example.service;

import org.example.database.DatabaseClass;
import org.example.userfiles.UserMessage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


public class MessageService {

    private Map<Long, UserMessage> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new UserMessage(1L, "Quarter thang", "freddie gibbs"));
        messages.put(2L, new UserMessage(2, "With them", "young thug"));

    }

    public List<UserMessage> getAllMessages() {
        return new ArrayList<UserMessage>(messages.values());
    }

    public List<UserMessage> getAllMessagesForYear(int year) {
          List<UserMessage> messagesForYear = new ArrayList<>();
          Calendar cal = Calendar.getInstance();
          for(UserMessage message : messages.values()){
              cal.setTime(message.getCreated());
              if(cal.get(Calendar.YEAR)== year){
                  messagesForYear.add(message);
              }
          } return messagesForYear;
    }


    public List<UserMessage> getAllMessagesPaiganated(int start, int size) {
         ArrayList<UserMessage> list = new ArrayList<>(messages.values());
         if(start +size > list.size()) return new ArrayList<UserMessage>();
         return list.subList(start, start + size);
    }



    public UserMessage getMessage(Long id){
        return messages.get(id);
    }

    public UserMessage addMessage(UserMessage message) {
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;
    }

    public UserMessage updateMessage(UserMessage message){
        if(message.getId()<= 0){
            return null;
        }
        messages.put(message.getId(),message);
        return message;
    }

    public UserMessage removeMessage(long id){
        return messages.remove(id);
    }

}
