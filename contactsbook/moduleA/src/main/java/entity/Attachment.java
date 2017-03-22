package entity;

import java.sql.Timestamp;

/**
 * Created by Alexey on 15.03.2017.
 */
public class Attachment {
    private int attachmentId;
    private String filePath;
    private String fileName;
    private Timestamp uploadDate;
    private String comment;
    private int contactId;

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "entity.Attachment{" +
                "attachmentId=" + attachmentId +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadDate=" + uploadDate +
                ", comment='" + comment + '\'' +
                ", contactId=" + contactId +
                '}'+'\n';
    }
}
