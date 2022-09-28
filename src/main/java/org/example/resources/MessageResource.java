package org.example.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.beans.MessageFilterBean;
import org.example.service.MessageService;
import org.example.userfiles.UserMessage;

import java.util.List;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService appService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserMessage> getMessage(@BeanParam MessageFilterBean filterBean) {

        if(filterBean.getYear() > 0){
            return appService.getAllMessages();
        }
        if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
            return appService.getAllMessagesPaiganated(filterBean.getStart(), filterBean.getSize());
        }
        return appService.getAllMessages();
    }

    @POST

    public UserMessage addMessage(UserMessage message) {
       return appService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")

    public UserMessage updateMessage(@PathParam("messageId") long messageId, UserMessage message) {
     message.setId(messageId);
        return appService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")

    public void deleteMessage(@PathParam("messageId") long messageId) {
     appService.removeMessage(messageId);
    }

    @GET
    @Path("/{messageId}")

    public UserMessage test(@PathParam("messageId") long messageId) {
        return appService.getMessage(messageId);
    }

    @Path("/{messageId}/comments")
        public CommentResource getCommentResource() {
            return new CommentResource();
        }
    }


