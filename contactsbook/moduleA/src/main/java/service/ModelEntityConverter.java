package service;

import entity.Attachment;
import entity.Contact;
import entity.PhoneNumber;
import model.AttachmentDTO;
import model.ContactDTO;
import model.PhoneNumberDTO;

/**
 * Created by Alexey on 21.03.2017.
 */
public class ModelEntityConverter {
    public PhoneNumber convertModelToEntity(PhoneNumberDTO model,int contactId){
        PhoneNumber entity=new PhoneNumber();
        entity.setNumberId(model.getNumberId());
        entity.setCountryCode(model.getCountryCode());
        entity.setOperatorCode(model.getOperatorCode());
        entity.setNumber(model.getNumber());
        entity.setType(model.getType());
        entity.setComment(model.getComment());
        entity.setContactId(contactId);
        return entity;
    }
    public Attachment convertModelToEntity(AttachmentDTO model,int contactId){
        Attachment entity=new Attachment();
        entity.setAttachmentId(model.getAttachmentId());
        entity.setFilePath(model.getFilePath());
        entity.setFileName(model.getFileName());
        entity.setUploadDate(model.getUploadDate());
        entity.setComment(model.getComment());
        entity.setContactId(contactId);
        return entity;
    }
    public Contact convertModelToEntity(ContactDTO model){
        Contact entity = new Contact(model.getName(),model.getSurname());
        entity.setContactId(model.getContactId());
        entity.setPatronymic(model.getPatronymic());
        entity.setBirth(model.getBirth());
        entity.setGender(model.getGender());
        entity.setCitizenship(model.getCitizenship());
        entity.setMaritalStatus(model.getMaritalStatus());
        entity.setWebsite(model.getWebsite());
        entity.setEmail(model.getEmail());
        entity.setJob(model.getJob());
        entity.setCountry(model.getCountry());
        entity.setCity(model.getCity());
        entity.setStreet(model.getStreet());
        entity.setPostalCode(model.getPostalCode());
        entity.setProfilePictureName(model.getProfilePictureName());
        return entity;
    }
}
