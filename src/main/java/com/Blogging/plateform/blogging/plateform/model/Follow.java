package com.Blogging.plateform.blogging.plateform.model;

import jakarta.persistence.*;


@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;


    @ManyToOne
    @JoinColumn(name = "fk_actual_user")
    User currentUser;

    @ManyToOne
    @JoinColumn(name = "fk_follower_of_actual_user")
    User currentUserFollower;

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUserFollower() {
		return currentUserFollower;
	}

	public void setCurrentUserFollower(User currentUserFollower) {
		this.currentUserFollower = currentUserFollower;
	}


}
