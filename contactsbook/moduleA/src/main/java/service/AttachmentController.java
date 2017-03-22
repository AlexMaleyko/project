package service;

import DAO.AttachmentDAOImpl;
import entity.Attachment;
import model.AttachmentDTO;

import java.sql.SQLException;

/**
 * Created by Alexey on 21.03.2017.
 */
public class AttachmentController {
    //getAll method is not needed as program uploads all phones by invoking EntityModelConvertion(attachment)
    public void saveAttachment(AttachmentDTO attachmentDTO, int contactId){
        Attachment attachment=(new ModelEntityConverter()).convertModelToEntity(attachmentDTO,contactId);
        try {
            (new AttachmentDAOImpl()).save(ConnectionClass.getConnection(),attachment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAttachment(AttachmentDTO attachmentDTO, int contactId){
        Attachment attachment=(new ModelEntityConverter()).convertModelToEntity(attachmentDTO,contactId);
        try {
            (new AttachmentDAOImpl()).save(ConnectionClass.getConnection(),attachment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
