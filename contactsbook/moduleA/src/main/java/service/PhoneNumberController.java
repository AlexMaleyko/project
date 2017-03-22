package service;

import DAO.PhoneNumberDAOImpl;
import entity.PhoneNumber;
import model.PhoneNumberDTO;

import java.sql.SQLException;

/**
 * Created by Alexey on 21.03.2017.
 */
public class PhoneNumberController {
    //getAll method is not needed as program uploads all phones by invoking EntityModelConvertion(contact)
    public void updatePhoneNumber(PhoneNumberDTO numberDTO, int contactId){
        PhoneNumber number=(new ModelEntityConverter()).convertModelToEntity(numberDTO,contactId);
        try {
            (new PhoneNumberDAOImpl()).update(ConnectionClass.getConnection(),number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePhoneNumber(PhoneNumberDTO numberDTO, int contactId){
        PhoneNumber number=(new ModelEntityConverter()).convertModelToEntity(numberDTO,contactId);
        try {
            (new PhoneNumberDAOImpl()).delete(ConnectionClass.getConnection(),number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void savePhoneNumber(PhoneNumberDTO numberDTO, int contactId){
        PhoneNumber number=(new ModelEntityConverter()).convertModelToEntity(numberDTO,contactId);
        try {
            (new PhoneNumberDAOImpl()).save(ConnectionClass.getConnection(),number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
