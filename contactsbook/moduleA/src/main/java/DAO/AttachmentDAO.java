package DAO;

import entity.Attachment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexey on 15.03.2017.
 */
public interface AttachmentDAO {
    void save(Connection conn, Attachment attachment) throws SQLException;

    List<Attachment> findByContactId(Connection conn, long contactId) throws SQLException;

    void delete(Connection conn, Attachment attachment) throws SQLException;

}
