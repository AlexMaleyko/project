package command;

import service.ContactController;
import service.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 10.04.2017.
 */
public class SendEmail implements Command{
    private EmailSender sender;
    private Connection conn;

    public SendEmail(Connection conn){
        this.conn=conn;
        sender = new EmailSender();
    }
    private static final org.slf4j.Logger LOGGER=
            org.slf4j.LoggerFactory.getLogger(SaveContact.class);

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("metod: execute");
        String[] recipients = request.getParameterValues("recipient");
        if(recipients == null){
            LOGGER.error("recipient is null");
        }
        List<Long> recipinestIds = new ArrayList<>();
        for(int i = 0; i < recipients.length; i++){
            recipinestIds.add(Long.parseLong(recipients[i]));
        }
        String text = request.getParameter("mailText").trim();
        String subject = request.getParameter("subject").trim();
        if(text == null){
            LOGGER.error("text is null");
        }
        if(subject == null){
            LOGGER.error("subject is null");
        }


        sender.sendEmail(conn, recipinestIds, subject, text);

        response.sendRedirect("ContactList");

    }
}
