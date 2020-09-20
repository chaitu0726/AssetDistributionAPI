package com.profile.Springbootbackend.model;

public class MailSend {
	
	private String name;
	private String userId;
	private String mailSubject;
	private String mailBody;

	public MailSend() {
		// TODO Auto-generated constructor stub
	}

	public MailSend(String name, String userId, String mailSubject, String mailBody) {
		super();
		this.name = name;
		this.userId = userId;
		this.mailSubject = mailSubject;
		this.mailBody = mailBody;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

}
