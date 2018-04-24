import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Main {
	
	public static void main(String[] args){
		
		MessageReader message;
		IntroMessage introMessage = new IntroMessage();
		
		if(args.length != 5){
			introMessage.showIntro();
		}
		else{
			try{
				
				String senderEmail = args[0];
				String host = "smtp.gmail.com";
				String senderPassword = args[1];
				String receiverEmail = args[2];
				String mailSubject = args[3];
			    
				message = new MessageReader();
			
				String mailMessage = message.getMessage(args[4]);
				
				//System.out.println(mailMessage);
				
				//mailMessage = "Hoy nai .. ";
				
				boolean sessionDebug = false;
				
				Properties properties = System.getProperties();
				
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "587");
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.required", "true");
				
				java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				
				Session mailSession = Session.getDefaultInstance(properties, null);
				mailSession.setDebug(sessionDebug);
				Message mail = new MimeMessage(mailSession);
				mail.setFrom(new InternetAddress(senderEmail));
				InternetAddress[] address = {new InternetAddress(receiverEmail)};
				mail.setRecipients(Message.RecipientType.TO, address);
				mail.setSubject(mailSubject);
				mail.setSentDate(new Date());
				mail.setText(mailMessage);
				
				Transport transport = mailSession.getTransport("smtp");
				transport.connect(host, senderEmail, senderPassword);
				transport.sendMessage(mail, mail.getAllRecipients());
				transport.close();
				
				System.out.println();
				System.out.println("Mail Sent to "+args[2]+" ! ");
				System.out.println();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
}
