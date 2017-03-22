package DAO;


import entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 19.03.2017.
 */
public class ContactDAOImpl implements ContactDAO {
    @Override
    public List<Contact> getAll(Connection conn) throws SQLException {
        List<Contact> contactList= new ArrayList<>();
        String query = "SELECT contact_id, name, surname, patronymic, birth, "+
                       "gender, citizenship, marital_status, website, email, "+
                       "job, country, city, street, postal_code, profile_picture_name "+
                        "FROM contact";
        try(
                PreparedStatement stmt = conn.prepareStatement(query)
        ){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Contact contact  = new Contact(rs.getInt(1), rs.getString(2),rs.getString(3),
                                               rs.getString(4),rs.getDate(5),rs.getString(6),
                                               rs.getString(7),rs.getString(8),rs.getString(9),
                                               rs.getString(10),rs.getString(11),rs.getString(12),
                                               rs.getString(13),rs.getString(14),rs.getString(15),
                                               rs.getString(16)
                                                );
                contactList.add(contact);
            }
        }
        return contactList;
    }

    @Override
    public Contact findById(Connection conn, int id) throws SQLException {
        Contact contact=null;
        String query="SELECT * FROM contact WHERE contact_id=?";
        try(
                PreparedStatement stmt=conn.prepareStatement(query)
        ){
           stmt.setInt(1,id);
           ResultSet rs = stmt.executeQuery();
           if (rs.next())
               contact = new Contact(rs.getInt(1), rs.getString(2),rs.getString(3),
                       rs.getString(4),rs.getDate(5),rs.getString(6),
                       rs.getString(7),rs.getString(8),rs.getString(9),
                       rs.getString(10),rs.getString(11),rs.getString(12),
                       rs.getString(13),rs.getString(14),rs.getString(15),
                       rs.getString(16)
               );
        }
        return contact;
    }

    @Override
    public void save(Connection conn, Contact contact) throws SQLException {
        String saveString = "INSERT  INTO contact (name,surname,patronymic, birth, gender, citizenship, marital_status, "+
                            "website,email,job,country,city,street,postal_code,profile_picture_name) "+
                               "VALUES (/*1 name*/ ?, /*2 surname*/ ?, /*3 patronymic*/?, /*4 birth*/?, "+
                "/*5 gender*/?, /*6 citizenship*/?, /*7 marital_status*/?, /*8 website*/?, /*9 email*/?, "+
                "/*10 job*/?, /*11 country*/?, /* 12 city*/?, /*13 street*/?, /*14 postal_code*/?, /*15 profile_picture_name*/?)";
        try(
                PreparedStatement stmt=conn.prepareStatement(saveString)
        ){
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getSurname());
            stmt.setString(3,contact.getPatronymic());
            stmt.setDate(4,contact.getBirth());
            stmt.setString(5,contact.getGender());
            stmt.setString(6,contact.getCitizenship());
            stmt.setString(7,contact.getMaritalStatus());
            stmt.setString(8,contact.getWebsite());
            stmt.setString(9,contact.getEmail());
            stmt.setString(10,contact.getJob());
            stmt.setString(11,contact.getCountry());
            stmt.setString(12,contact.getCity());
            stmt.setString(13,contact.getStreet());
            stmt.setString(14,contact.getPostalCode());
            stmt.setString(15,contact.getProfilePictureName());
            stmt.executeUpdate();
        }

    }

    @Override
    public void delete(Connection conn, Contact contact) throws SQLException {
        String deleteString="DELETE FROM contact WHERE contact_id=?";
        try(
                PreparedStatement stmt=conn.prepareStatement(deleteString)
        ){
            stmt.setInt(1,contact.getContactId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Connection conn, Contact contact) throws SQLException {
        String updateString="UPDATE contact "+
                "SET name=?, surname=?, patronymic=?, birth= ? , "+
                "gender=?, citizenship=?, marital_status=?, website=?, email=?, "+
                "job=?, country=?, city=?, street=?, postal_code=?, profile_picture_name=? "+
                "WHERE contact_id=?";
        try(
                PreparedStatement stmt=conn.prepareStatement(updateString)
        ){
            stmt.setString(1,contact.getName());
            stmt.setString(2,contact.getSurname());
            stmt.setString(3,contact.getPatronymic());
            stmt.setString(4,"1998-12-03");
            stmt.setString(5,contact.getGender());
            stmt.setString(6,contact.getCitizenship());
            stmt.setString(7,contact.getMaritalStatus());
            stmt.setString(8,contact.getWebsite());
            stmt.setString(9,contact.getEmail());
            stmt.setString(10,contact.getJob());
            stmt.setString(11,contact.getCountry());
            stmt.setString(12,contact.getCity());
            stmt.setString(13,contact.getStreet());
            stmt.setString(14,contact.getPostalCode());
            stmt.setString(15,contact.getProfilePictureName());
            stmt.setInt(16,contact.getContactId());
            stmt.executeUpdate();
        }
    }
}
