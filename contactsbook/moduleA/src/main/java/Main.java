import DAO.AttachmentDAOImpl;
import DAO.ContactDAOImpl;
import DAO.PhoneNumberDAOImpl;
import entity.Attachment;
import entity.Contact;
import entity.PhoneNumber;
import org.apache.commons.io.FileUtils;
import org.joda.time.LocalDate;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import service.BirthdayMailJob;
import service.ConnectionClass;
import service.ContactController;
import service.TemplateMessage;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Alexey on 17.03.2017.
 */
public class Main {


    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, IOException, SchedulerException {
        /*Properties properties = new Properties();
        String propFileName = "email.properties";
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(propFileName);
        properties.load(inputStream);*/
         Properties properties;
         String propFileName = "fileStorage.properties";
        properties = new Properties();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(propFileName);
        properties.load(inputStream);
        System.out.println(properties.getProperty("defaultPicturePath"));

        /*JobDetail job = JobBuilder.newJob(BirthdayMailJob.class)
                .withIdentity("birthdayJob", "contactsbook").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("BirthdayTrigger", "contactsbook")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5).repeatForever())
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);*/

        STGroup messageTemplates = new STGroupFile("messageTemplates.stg");
        ST template1 = messageTemplates.getInstanceOf("birthday");
        template1.add("name", "Alex");
        template1.add("patronymic", "James");
        System.out.println(template1.render());



       /* final String username = "username@gmail.com";
        final String password = "password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(properties.getProperty("username"),
                                properties.getProperty("password"));
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.getProperty("username")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("recipientr88@gmail.com"));
            message.setSubject("hello", "UTF-8");
            message.setText("Привет, это мое первое электронное сообщение", "UTF-8");
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("hello");*/





        /*PhoneNumber phoneNumber=new PhoneNumber();
        phoneNumber.setComment("Hello");
        phoneNumber.setContactId(2);
        phoneNumber.setCountryCode("+375");
        phoneNumber.setOperatorCode("29");
        phoneNumber.setNumber("6609198");
        phoneNumber.setType("m");
        PhoneNumberDAOImpl obj= new PhoneNumberDAOImpl();
        try {
            obj.save(ConnectionClass.getConnection(),phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        phoneNumber.setNumberId(4);
        obj.delete(ConnectionClass.getConnection(),phoneNumber);
        phoneNumber.setNumberId(1);
        phoneNumber.setOperatorCode("25");
        obj.update(ConnectionClass.getConnection(),phoneNumber);
        System.out.println((obj.getAll(ConnectionClass.getConnection())).toString());
        System.out.println("Search result: ");
        System.out.println((obj.findByContactId(ConnectionClass.getConnection(),2)).toString());
        System.out.println("Success");

        ContactDAOImpl contactAOImp=new ContactDAOImpl();
        System.out.println((contactAOImp.findById(ConnectionClass.getConnection(), 3)).toString());
        System.out.println((contactAOImp.getAll(ConnectionClass.getConnection())).toString());
        Contact contact=new Contact("Федор","Емельяненко");
        contact.setBirth(new java.sql.Date(1345352345));
        contactAOImp.save(ConnectionClass.getConnection(),contact);
        contactAOImp.save(ConnectionClass.getConnection(),contact);
        contact.setContactId(5);
        String birthDate="1998-12-03";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date=null;
        java.sql.Date sqlDate= null;
        try {
            date = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString() + date.getTime());
        System.out.println("trouble1");
        sqlDate=new java.sql.Date(date.getTime());
        contact.setBirth(sqlDate);
        contact.setPatronymic("Васильевич");
        contact.setGender("м");
        contact.setCity("Ровно");
        System.out.println("trouble2");
        System.out.println((contact.getBirth()).toString());
        contactAOImp.save(ConnectionClass.getConnection(),contact);
        contactAOImp.update(ConnectionClass.getConnection(),contact);
        contactAOImp.save(ConnectionClass.getConnection(),contact);
        System.out.println("Pause");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        contact.setContactId(6);
        contactAOImp.delete(ConnectionClass.getConnection(),contact);
        System.out.println("");
        System.out.println();

        AttachmentDAOImpl aoImp=new AttachmentDAOImpl();
        Attachment attachment=new Attachment();
        attachment.setContactId(5);
        attachment.setFileName("text.pdf");
        attachment.setFilePath("c:/Documents/MyDocuments/Folder");
        aoImp.save(ConnectionClass.getConnection(),attachment);
        aoImp.save(ConnectionClass.getConnection(),attachment);
        System.out.println("Pause");
        attachment.setAttachmentId(1);
        aoImp.delete(ConnectionClass.getConnection(),attachment);
        System.out.println((aoImp.findByContactId(ConnectionClass.getConnection(),1)).toString());*/
    }
}
