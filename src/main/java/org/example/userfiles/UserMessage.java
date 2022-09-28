package org.example.userfiles;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UserMessage {

    private long id;
    private String message;
    private String author;
    private Date created;
private Map<Long, UserComment> comments = new HashMap<>();

    public UserMessage(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }

    public UserMessage() {}



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


public Map<Long, UserComment> getComments() {
        return comments;
}

    public void setComments(Map<Long, UserComment> comments) {
        this.comments = comments;
    }
}
