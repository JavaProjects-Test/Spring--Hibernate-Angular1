/**
 * 
 */
package com.bostaniaonline.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bostaniaonline.vo.UserSignUp;

/**
 * @author Sahil.Kaushik
 * 
 */
public class UserMail {
	public static boolean sendMail(UserSignUp userSignup) {

		final String userName = "sahil.kaushik@niit.com";
		final String password = "password@1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "172.17.1.91");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sahil.kaushik@niit.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userSignup.getEmailId()));
			message.setSubject("Testing Subject");
			message.setContent(
					"<h1 style=color:blue> This is a service.</h1><br><h3>Hi "
							+ userSignup.getFirstName()
							+ " "
							+ userSignup.getLastName()
							+ "</h3><br>"
							+ "Your Password has been changed to "
							+ userSignup.getPassword()
							+ "<br>Please click on 'Let's Login Now' button for login on your Bostainia screen<br>Thanks,<br><h2>Bostania Service</h2>"

					, "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

}
