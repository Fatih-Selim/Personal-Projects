package org.example.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.CommentService;
import org.example.userfiles.UserComment;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    public CommentService commentService = new CommentService();

    @GET
    public List<UserComment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @POST
    public UserComment addMessage(@PathParam("messageId") long messageId, UserComment comment){
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public UserComment updateMessages(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, UserComment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public UserComment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
        return commentService.removeComment(messageId, commentId);
    }


    @GET
    @Path("/{commentId}")
    public String test2(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return "Method to return messsage id: " + messageId + "Method to return comment id: " + commentId;
    }

}
