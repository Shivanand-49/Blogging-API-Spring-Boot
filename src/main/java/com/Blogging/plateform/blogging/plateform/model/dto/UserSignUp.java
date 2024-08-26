package com.Blogging.plateform.blogging.plateform.model.dto;

public class UserSignUp {
   
	private boolean signUpStatus;
    private String signUpStatusMessage;
	
	public boolean isSignUpStatus() {
		return signUpStatus;
	}
	public void setSignUpStatus(boolean signUpStatus) {
		this.signUpStatus = signUpStatus;
	}
	public String getSignUpStatusMessage() {
		return signUpStatusMessage;
	}
	public void setSignUpStatusMessage(String signUpStatusMessage) {
		this.signUpStatusMessage = signUpStatusMessage;
	}
	public UserSignUp(boolean signUpStatus, String signUpStatusMessage) {
		super();
		this.signUpStatus = signUpStatus;
		this.signUpStatusMessage = signUpStatusMessage;
	}
	
    
}
