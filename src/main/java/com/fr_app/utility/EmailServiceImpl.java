package com.fr_app.utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender sender;
	@Override
	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message =sender.createMimeMessage();

	try {
		MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
		messageHelper.setTo(toAddress);
		messageHelper.setSubject("itinerary of flight");
		messageHelper.setText("please find the attached");
		messageHelper.addAttachment("itinerary", new File(filePath));
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	
	sender.send(message);
	}

}
