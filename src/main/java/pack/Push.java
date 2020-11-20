package pack;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Push {

	// Attributes Connection

	private final static String username = "CimpaCyber@gmail.com";
	private final static String password = "@Testcimpa";
	// Attributes

	private static int frequency = 2;
	// Getters

	public static String getUsername() {
		return username;

	}

	public static String getPassword() {
		return password;

	}

	// Method Mail Creation

	public static Message createMailBody(Session session) throws AddressException, MessagingException, SQLException {

		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(Push.getUsername()));

		// Obtention MailList

		Abonne ab = new Abonne();
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ab.mailList()));
		message.setSubject("CyberSecurite News");
		message.setContent(htmlMail(), "text/html");
		return message;

	}

	public static String htmlMail() {
		String mailBody = null;
		mailBody = "<h1>Bonjour, Une nouvelle ulnérabilité vient d'être ajoutée. Merci de cliquer sur le lien suivant: http://localhost:8080/Hack_sopra/index.jsp</h1>";
		return mailBody;

	}

	public static void sendMail() throws SQLException {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}

		});

		try {

			Transport.send(createMailBody(session));

			System.out.println("Done");

		} catch (MessagingException e) {

			e.printStackTrace();

		}

	}

}
