package service;


import DAO.AttachmentDAOImpl;
import DAO.PhoneNumberDAOImpl;
import entity.Attachment;
import entity.Contact;
import entity.PhoneNumber;
import model.AttachmentDTO;
import model.ContactDTO;
import model.PhoneNumberDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 21.03.2017.
 */
public class EntityModelConverter {

    public PhoneNumberDTO convertEntityToModel(PhoneNumber entity){
        PhoneNumberDTO model=new PhoneNumberDTO();
        model.setNumberId(entity.getNumberId());
        model.setCountryCode(entity.getCountryCode());
        model.setOperatorCode(entity.getOperatorCode());
        model.setNumber(entity.getNumber());
        model.setType(entity.getType());
        model.setComment(entity.getComment());
        return model;
    }

    public AttachmentDTO convertEntityToModel(Attachment entity){
        AttachmentDTO model=new AttachmentDTO();
        model.setAttachmentId(entity.getAttachmentId());
        model.setFilePath(entity.getFilePath());
        model.setFileName(entity.getFileName());
        model.setUploadDate(entity.getUploadDate());
        model.setComment(entity.getComment());
        return model;
    }

    public ContactDTO convertEntityToModel(Contact entity){
        ContactDTO model=new ContactDTO();
        model.setContactId(entity.getContactId());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        model.setBirth(entity.getBirth());
        model.setGender(entity.getGender());
        model.setCitizenship(entity.getCitizenship());
        model.setMaritalStatus(entity.getMaritalStatus());
        model.setWebsite(entity.getWebsite());
        model.setEmail(entity.getEmail());
        model.setJob(entity.getJob());
        model.setCountry(entity.getCountry());
        model.setCity(entity.getCity());
        model.setStreet(entity.getStreet());
        model.setPostalCode(entity.getPostalCode());
        model.setProfilePictureName(entity.getProfilePictureName());
        /*Setting phoneNumberDTOList*/
        List<PhoneNumberDTO> numberDTOList=new ArrayList<>();
        List<PhoneNumber> numberEntityList=null;

        try {
            numberEntityList= (new PhoneNumberDAOImpl()).findByContactId(
                    ConnectionClass.getConnection(),entity.getContactId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(PhoneNumber number:numberEntityList) {
            numberDTOList.add(convertEntityToModel(number));
        }
        model.setNumberDTOList(numberDTOList);
        /*Setting attachmentDTOList*/
        List<AttachmentDTO> attachmentDTOList=new ArrayList<>();
        List<Attachment> attachmentEntityList=null;
        try {
            attachmentEntityList=(new AttachmentDAOImpl()).findByContactId(
                    ConnectionClass.getConnection(),entity.getContactId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Attachment attachment: attachmentEntityList) {
            attachmentDTOList.add(convertEntityToModel(attachment));
        }
        model.setAttachmentDTOList(attachmentDTOList);
        return model;
    }
}
