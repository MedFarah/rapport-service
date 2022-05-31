package org.tn.zitouna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Value("$ {jobs.menseul.value}")
	private String isEnabledMenseul;
	@Value("$ {jobs.bimenseul.value}")
	private String isEnabledBimenseul;
	@Value("$ {jobs.trimenseul.value}")
	private String isEnabledTriMenseul;
	@Value("$ {send.email.to:wissalyahyaoui97@gmail.com}")
	private String to;
	@Value("$ {send.email.subject:envoie declaration}")
	private String subject;
	@Value("$ {send.email.body}")
	private String body;

	/**
	 * This method will send compose and send the message
	 */
	// kol 3 mois
	@Scheduled(cron = "0 0 0 * */3 *")
	public void sendMailTrimenseul() {
		if (isEnabledTriMenseul.equals("true")) {
			// do work here
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("");
			message.setSubject("");
			message.setText("");
			mailSender.send(message);
		}
	}

	@Scheduled(cron = "0 0 0 * */2 *")
	public void sendMailBimenseul() {
		if (isEnabledBimenseul.equals("true")) {
			// do work here
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("");
			message.setSubject("");
			message.setText("");
			mailSender.send(message);
		}
	}

	@Scheduled(cron = "0 0 0 * */1 *")
	public void sendMailMenseul() {
		if (isEnabledMenseul.equals("true")) {
			// do work here
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("");
			message.setSubject("");
			message.setText("");
			mailSender.send(message);
		}
	}
	
	public void sendMail(String to, String subject, String body) {
		
			// do work here
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		
	}
}
