package service;

import DAO.ContactDAOImpl;
import entity.Contact;
import model.ContactDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 21.03.2017.
 */
public class ContactController {

    public List<ContactDTO> getAllContactDTO() {
        List<ContactDTO> contactDTOList = new ArrayList<>();
        List<Contact> contactList = null;
        try {
            contactList = (new ContactDAOImpl()).getAll(ConnectionClass.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        EntityModelConverter converter = new EntityModelConverter();
        for (Contact contact : contactList)
            contactDTOList.add(converter.convertEntityToModel(contact));
        return contactDTOList;
    }

    public void updateContact(ContactDTO contactDTO){
        Contact contact=(new ModelEntityConverter()).convertModelToEntity(contactDTO);
        try {
            (new ContactDAOImpl()).update(ConnectionClass.getConnection(),contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(ContactDTO contactDTO){
        Contact contact=(new ModelEntityConverter()).convertModelToEntity(contactDTO);
        try {
            (new ContactDAOImpl()).delete(ConnectionClass.getConnection(),contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveContact(ContactDTO contactDTO){
        Contact contact=(new ModelEntityConverter()).convertModelToEntity(contactDTO);
        try {
            (new ContactDAOImpl()).save(ConnectionClass.getConnection(),contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
