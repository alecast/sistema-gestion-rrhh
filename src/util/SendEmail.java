package util;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class SendEmail  
{  


public static void send(String to,String subject,String msg){ 
	
	  String from = "sistemagestionrrhhtest@gmail.com";
	  String password = "rrhh1234";	
      
	  //Get properties object    
      Properties props = new Properties();    
      props.put("mail.smtp.host", "smtp.gmail.com");    
      props.put("mail.smtp.socketFactory.port", "465");    
      props.put("mail.smtp.socketFactory.class",    
                "javax.net.ssl.SSLSocketFactory");    
      props.put("mail.smtp.auth", "true");    
      props.put("mail.smtp.port", "465");    
      
      //get Session   
      Session session = Session.getDefaultInstance(props,    
       new javax.mail.Authenticator() {    
       protected PasswordAuthentication getPasswordAuthentication() {    
       return new PasswordAuthentication(from,password);  
       }    
      });    
      
      //compose message    
      try {    
       MimeMessage message = new MimeMessage(session);    
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
       message.setSubject(subject);    
       message.setText(msg);    
       
       //send message  
       Transport.send(message);       
      } catch (MessagingException e) {throw new RuntimeException(e);}    
         
}  
} 

