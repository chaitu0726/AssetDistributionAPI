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
import static com.profile.Springbootbackend.util.ProfileConstants.ADMIN_EMAIL;
import static com.profile.Springbootbackend.util.ProfileConstants.USER_EMAIL;
import static com.profile.Springbootbackend.util.ProfileConstants.USER_EMAIL_ID;

@Service
public class AwsSesServiceImpl implements AwsSesService{
	
	private AmazonSimpleEmailService amazonSimpleEmailService;
	
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
		      System.out.println("Email sent!");
		    } catch (Exception ex) {
		      System.out.println("The email was not sent. Error message: " 
		          + ex.getMessage());
		    }
		}

}
