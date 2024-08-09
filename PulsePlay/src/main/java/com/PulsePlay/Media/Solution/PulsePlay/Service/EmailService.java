package com.PulsePlay.Media.Solution.PulsePlay.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public void sendemail(Map<String, Object> model, String email) {
		
		
		MimeMessage message=sender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			
			Template t = config.getTemplate("email-template.ftl");
			String html=FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			helper.setTo(email);
			helper.setText(html, true);
			helper.setSubject("PulsePlay Otp for Verify");
			helper.setFrom("pulseplaymediasolution100@gmail.com");
			sender.send(message);
			
			
			
		} catch (MessagingException | IOException | TemplateException e) {
			// TODO: handle exception
			
		}
		
		
	}
	
	

}
