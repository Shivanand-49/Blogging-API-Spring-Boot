package com.Blogging.plateform.blogging.plateform.service;


import com.Blogging.plateform.blogging.plateform.model.Comment;
import com.Blogging.plateform.blogging.plateform.model.Post;
import com.Blogging.plateform.blogging.plateform.model.User;
import com.Blogging.plateform.blogging.plateform.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String createPost(Post post) {
        post.setPostCreatedTimeStamp(LocalDateTime.now());
        postRepo.save(post);
        return "Post uploaded!!!!";
    }

    public String removePost(Integer postId, User user) {

        Post post  = postRepo.findById(postId).orElse(null);
        if(post != null && post.getPostOwner().equals(user))
        {
            postRepo.deleteById(postId);
            return "Removed successfully";
        }
        else if (post == null)
        {
            return "Post to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validatePost(Post instaPost) {
        return (instaPost!=null && postRepo.existsById(instaPost.getPostId()));
    }


    public Post getPostById(Integer id) {
        return postRepo.findById(id).orElse(null);
    }


    public String updatePost(Post post) {
        Post existingPost = postRepo.findById(post.getPostId()).orElse(null);
        if (existingPost == null) {
            // Handle not found scenario
            // You can throw an exception or return null/empty value based on your requirement
            return "No post Found";
        }else {
        existingPost.setPostContent(post.getPostContent());
        existingPost.setPostCaption(post.getPostCaption());
        existingPost.setPostLocation(post.getPostLocation());
        post.setPostCreatedTimeStamp(LocalDateTime.now());
        return "Post Updated successfully";}
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }


}