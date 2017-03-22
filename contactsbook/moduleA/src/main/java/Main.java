import DAO.AttachmentDAOImpl;
import DAO.ContactDAOImpl;
import DAO.PhoneNumberDAOImpl;
import entity.Attachment;
import entity.Contact;
import entity.PhoneNumber;
import service.ConnectionClass;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Alexey on 17.03.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        System.out.println("hello");
        PhoneNumber phoneNumber=new PhoneNumber();
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
        System.out.println((aoImp.findByContactId(ConnectionClass.getConnection(),1)).toString());
    }
}
