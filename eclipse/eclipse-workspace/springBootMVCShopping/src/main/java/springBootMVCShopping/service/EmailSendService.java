package springBootMVCShopping.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	@Autowired
	JavaMailSender mailSender;
	
	public void mailSend(String fromEmail, String toEmail, String subject, String contents) {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			msg.setHeader("content-Type", "text/html; charset=UTF-8");
			msg.setContent(contents, "text/html; charset=UTF-8");
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
			mailSender.send(msg);
			} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
