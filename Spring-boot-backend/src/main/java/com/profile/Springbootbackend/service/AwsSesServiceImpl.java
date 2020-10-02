package com.profile.Springbootbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.profile.Springbootbackend.model.MailSend;

import static com.profile.Springbootbackend.util.ProfileConstants.ADMIN_EMAIL;
import static com.profile.Springbootbackend.util.ProfileConstants.USER_EMAIL_ID;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AwsSesServiceImpl implements AwsSesService{
	
	private AmazonSimpleEmailService amazonSimpleEmailService;
	
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	
	@Autowired
	public AwsSesServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider) {
		this.amazonSimpleEmailService = AmazonSimpleEmailServiceClientBuilder.standard()
				  						.withCredentials(awsCredentialsProvider)
				  						.withRegion(awsRegion.getName()).build();
	}
	
	@Override
	public void sendEmail(int userId) {
		
		   final String SUBJECT = "Assets Assign";
		   final String TEXTBODY = "Assets Assign to User "+userId+" please go and Check on portal";

		    try {
		      SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(USER_EMAIL_ID))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(SUBJECT)))
		          .withSource(ADMIN_EMAIL);
		         
		      this.amazonSimpleEmailService.sendEmail(request);
		      LOGGER.log(Level.INFO, "Email Sent!!"); 
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    	LOGGER.log(Level.WARNING, "Email Not Sent"); 
		    }
		}

	@Override
	public boolean sendmailToAdmin(MailSend mailSend) {
		
		// final String SUBJECT = "Assets Assign";
		   final String TEXTBODY = "Query From : "+ mailSend.getName()+"\r\n"+
				   					"User ID: "+mailSend.getUserId()+"\r\n"+
				   					"\r\n"+"\r\n"+
				   					mailSend.getMailBody();

		    try {
		      SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(USER_EMAIL_ID))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(mailSend.getMailSubject())))
		          .withSource(ADMIN_EMAIL);
		         
		      this.amazonSimpleEmailService.sendEmail(request);
		      LOGGER.log(Level.INFO, "Email Sent to admin!!"); 
		      return true;
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    	LOGGER.log(Level.WARNING, "Email Not Sent"); 
		      return false;
		    }
	}

}
