package com.Blogging.plateform.blogging.plateform.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "PostComment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private String commentBody;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private LocalDateTime commentCreationTimeStamp;


    @ManyToOne
    @JoinColumn(name = "fk_comment_post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "fk_commenter_id")
    private User commenter;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public LocalDateTime getCommentCreationTimeStamp() {
		return commentCreationTimeStamp;
	}

	public void setCommentCreationTimeStamp(LocalDateTime commentCreationTimeStamp) {
		this.commentCreationTimeStamp = commentCreationTimeStamp;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}
    
    

}
