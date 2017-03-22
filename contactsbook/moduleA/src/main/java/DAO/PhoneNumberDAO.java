package DAO;

import entity.PhoneNumber;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexey on 15.03.2017.
 */
public interface PhoneNumberDAO {
    void save(Connection conn, PhoneNumber phoneNumber) throws SQLException;
    List<PhoneNumber> findByContactId(Connection conn, int contact_id) throws SQLException;
    List<PhoneNumber> getAll (Connection conn) throws SQLException;
    void update(Connection conn,PhoneNumber phoneNumber) throws SQLException;
    void delete(Connection conn,PhoneNumber phoneNumber) throws SQLException;
}
