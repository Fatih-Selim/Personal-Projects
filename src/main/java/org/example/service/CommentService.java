package org.example.service;

import org.example.database.DatabaseClass;
import org.example.userfiles.UserComment;
import org.example.userfiles.UserMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long, UserMessage> messages = DatabaseClass.getMessages();


    public List<UserComment>  getAllComments(long messageId){
        Map<Long, UserComment> comments = messages.get(messageId).getComments();
        return new ArrayList<UserComment>(comments.values());
    }

    public UserComment getComment(long messageId, long commentId) {
        Map<Long, UserComment> comments =messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public UserComment addComment(long messageId, UserComment comment) {
        Map<Long, UserComment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(),comment);
        return comment;
    }

    public UserComment updateComment(long messageId, UserComment comment) {
        Map<Long, UserComment> comments= messages.get(messageId).getComments();
        if(comment.getId() <=0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public UserComment removeComment(long messageId, long commentId){
        Map<Long, UserComment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }

}
