package entity;

import java.sql.Timestamp;

/**
 * Created by Alexey on 15.03.2017.
 */
public class Attachment {
    private long attachmentId;
    private String filePath;
    private String fileName;
    private Timestamp uploadDate;
    private String comment;
    private long contactId;

    public long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(long attachmentId) {
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

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
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
