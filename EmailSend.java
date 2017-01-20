/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TsodikovA
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class EmailSend {
 /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
      
     
        String emails;
     
       try{
            String host ="smtp.gmail.com" ;
            String user = "etsodikov056@student.fuhsd.org"; //sender email
            String pass = "eli192837465";  //sender password
            String to[] = {"elitsodikov@gmail.com","gogetaatss12@gmail.com"}; //array of everyone your sending the email to
            String from = user;
            String subject = "Yo waddup";  //enter subject
            String messageText = "This message was sent from java \n hope this works"; //Message in the email
           

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

           
            Session mailSession = Session.getDefaultInstance(props, null);
           
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            for(int a=0;a<to.length;a++){ //sending the email to everyone in the array through a for loop
                InternetAddress[] address = {new InternetAddress(to[a])};
                msg.setRecipients(Message.RecipientType.TO, address);
            
                msg.setSubject(subject); msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport=mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                        }
            System.out.println("all emails sent"); //all the e-mails are sent
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
