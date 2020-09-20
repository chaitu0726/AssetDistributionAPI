package com.profile.Springbootbackend.service;

import com.profile.Springbootbackend.model.MailSend;

public interface AwsSesService {
	 public void sendEmail(int userId);
	 public boolean sendmailToAdmin(MailSend mailSend);
}
