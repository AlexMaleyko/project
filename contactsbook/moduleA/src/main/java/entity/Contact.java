package entity; /**
 * Created by Alexey on 15.03.2017.
 */
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Contact {
    private int contactId;
    private String name;
    private String surname;
    private String patronymic;
    private java.sql.Date birth;
    private String gender;
    private String citizenship;
    private String maritalStatus;
    private String website;
    private String email;
    private String job;
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String profilePictureName;

    public Contact(int contactId, String name, String surname,
                   String patronymic, Date birth, String gender,
                   String citizenship, String maritalStatus, String website,
                   String email, String job, String country, String city,
                   String street, String postalCode, String profilePictureName
    ) {
        this.contactId = contactId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birth = birth;
        this.gender = gender;
        this.citizenship = citizenship;
        this.maritalStatus = maritalStatus;
        this.website = website;
        this.email = email;
        this.job = job;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.profilePictureName = profilePictureName;
    }

    public Contact(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
    public int getContactId() {
        return contactId;
    }
    public void setContactId(int contactId){
        this.contactId=contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public java.sql.Date getBirth() {
        return birth;
    }

    public void setBirth(java.sql.Date birth) {
       /* SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date=null;
        java.sql.Date sqlDate= null;
        try {
           date = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sqlDate=new Date(date.getTime());*/
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(String profilePictureName) {
        this.profilePictureName = profilePictureName;
    }

    @Override
    public String toString() {
        return "entity.Contact{" +
                "contactId=" + contactId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birth=" + birth +
                ", gender='" + gender + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", profilePictureName='" + profilePictureName + '\'' +
                '}'+'\n';
    }
}
