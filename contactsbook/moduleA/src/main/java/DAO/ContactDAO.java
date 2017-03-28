package DAO;

import entity.Contact;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexey on 15.03.2017.
 */
public interface ContactDAO {
    List<Contact> getAll(Connection conn) throws SQLException;

    Contact findById(Connection conn, long id) throws SQLException;

    void save(Connection conn, Contact contact) throws SQLException;

    void delete(Connection conn, Contact contact) throws SQLException;

    void update(Connection conn, Contact contact) throws SQLException;
}
