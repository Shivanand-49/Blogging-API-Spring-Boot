package com.Blogging.plateform.blogging.plateform.controller;

import com.Blogging.plateform.blogging.plateform.model.Comment;
import com.Blogging.plateform.blogging.plateform.model.Follow;
import com.Blogging.plateform.blogging.plateform.model.Post;
import com.Blogging.plateform.blogging.plateform.model.User;
import com.Blogging.plateform.blogging.plateform.model.dto.UserSignIn;
import com.Blogging.plateform.blogging.plateform.model.dto.UserSignUp;
import com.Blogging.plateform.blogging.plateform.repository.IUserRepo;
import com.Blogging.plateform.blogging.plateform.service.AuthenticationService;
import com.Blogging.plateform.blogging.plateform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("user/signup")
    public UserSignUp signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }
    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid UserSignIn userSignIn)
    {
        return userService.signInUser(userSignIn);
    }
    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }
    @PostMapping("post")
    public String createPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @DeleteMapping("post")
    public String removePost(@RequestParam Integer postId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removePost(postId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    //commenting functionalities on instagram

    @PostMapping("comment")
    public String addComment(@RequestBody Comment comment, @RequestParam String commenterEmail, @RequestParam String commenterToken)
    {
        if(authenticationService.authenticate(commenterEmail,commenterToken)) {
            return userService.addComment(comment,commenterEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }


    @DeleteMapping("comment")
    public String removeComment(@RequestParam Integer commentId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeComment(commentId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @PostMapping("follow")
    public String followUser(@RequestBody Follow follow, @RequestParam String followerEmail, @RequestParam String followerToken)
    {
        if(authenticationService.authenticate(followerEmail,followerToken)) {
            return userService.followUser(follow,followerEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @DeleteMapping("unfollow/target/{followId}")
    public String unFollowUser(@PathVariable Integer followId, @RequestParam String followerEmail, @RequestParam String followerToken)
    {
        if(authenticationService.authenticate(followerEmail,followerToken)) {
            return userService.unFollowUser(followId,followerEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @PutMapping("user/UpdatePost")
    public String updatePost(@RequestBody Post post,@RequestParam String email, @RequestParam String token){
        if(authenticationService.authenticate(email,token)) {
            return userService.updatePost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = userService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
//    @GetMapping("user/{postId}")
//    public List<Comment> getCommentsByPostId(
//            @PathVariable Integer postId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//            return userService.getCommentsByPostId(postId, page, size);
//    }

}
