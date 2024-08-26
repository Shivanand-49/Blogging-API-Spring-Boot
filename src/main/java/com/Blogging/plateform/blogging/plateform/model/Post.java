package com.Blogging.plateform.blogging.plateform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PostId;
    private String postContent;
    private String postCaption;
    private String postLocation;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime postCreatedTimeStamp;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "fk_post_user_id")
    private User postOwner;
	public Integer getPostId() {
		return PostId;
	}
	public void setPostId(Integer postId) {
		PostId = postId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostCaption() {
		return postCaption;
	}
	public void setPostCaption(String postCaption) {
		this.postCaption = postCaption;
	}
	public String getPostLocation() {
		return postLocation;
	}
	public void setPostLocation(String postLocation) {
		this.postLocation = postLocation;
	}
	public LocalDateTime getPostCreatedTimeStamp() {
		return postCreatedTimeStamp;
	}
	public void setPostCreatedTimeStamp(LocalDateTime postCreatedTimeStamp) {
		this.postCreatedTimeStamp = postCreatedTimeStamp;
	}
	public User getPostOwner() {
		return postOwner;
	}
	public void setPostOwner(User postOwner) {
		this.postOwner = postOwner;
		
	}
    
    
}

