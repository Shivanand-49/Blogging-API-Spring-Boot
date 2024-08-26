package com.Blogging.plateform.blogging.plateform.service;

import com.Blogging.plateform.blogging.plateform.model.Comment;
import com.Blogging.plateform.blogging.plateform.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        commentRepo.save(comment);
        return "Comment has been added!!!";
    }

    public Comment findComment(Integer commentId) {
        return  commentRepo.findById(commentId).orElse(null);
    }

    public void removeComment(Comment comment) {
        commentRepo.delete(comment);
    }


//    public List<Comment> getComments(Integer postId) {
//        return commentRepo.getCommentsByPostId(postId);
//    }
}