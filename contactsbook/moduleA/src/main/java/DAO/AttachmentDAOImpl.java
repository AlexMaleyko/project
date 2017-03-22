package DAO;

import entity.Attachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 19.03.2017.
 */
public class AttachmentDAOImpl implements AttachmentDAO {

    @Override
    public void save(Connection conn, Attachment attachment) throws SQLException {
        String saveStatement ="INSERT INTO attachment (file_path,file_name,comment,contact_id)"+
                              "VALUES (?, ?, ?, ?)";
        try(
                PreparedStatement stmt = conn.prepareStatement(saveStatement)
        ){
            stmt.setString(1, attachment.getFilePath());
            stmt.setString(2,attachment.getFileName());
            stmt.setString(3,attachment.getComment());
            stmt.setInt(4,attachment.getContactId());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Attachment> findByContactId(Connection conn, int contactId) throws SQLException {
        List<Attachment> attachmentList=new ArrayList<>();
        String query = "SELECT attachment_id, file_path, file_name, upload_date, comment "+
                       "FROM attachment WHERE contact_id= ?";
        try(
                PreparedStatement stmt=conn.prepareStatement(query)
        ){
            stmt.setInt(1,contactId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Attachment attachment = new Attachment();
                attachment.setAttachmentId(rs.getInt(1));
                attachment.setFilePath(rs.getString(2));
                attachment.setFileName(rs.getString(3));
                attachment.setUploadDate(rs.getTimestamp(4));
                attachment.setComment(rs.getString(5));
                attachment.setContactId(contactId);
                attachmentList.add(attachment);
            }
        }
        return attachmentList;

    }

    @Override//добавить действия по удалению из файловой системы
    public void delete(Connection conn, Attachment attachment) throws SQLException {
        String deleteString = "DELETE FROM attachment WHERE attachment_id=?";
        try(
                PreparedStatement stmt = conn.prepareStatement(deleteString)
        ){
            stmt.setInt(1,attachment.getAttachmentId());
            stmt.executeUpdate();
        }

    }
}
