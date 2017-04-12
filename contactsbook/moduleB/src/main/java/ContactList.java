import command.Command;
import command.GetContactList;
import model.ContactDTO;
import service.ConnectionClass;
import service.ContactController;
import service.TemplateMessage;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexey on 24.03.2017.
 */
public class ContactList extends HttpServlet {
    private static final org.slf4j.Logger LOGGER=
            org.slf4j.LoggerFactory.getLogger(SaveContact.class);
    private Connection conn;

    @Override
    public void init(){
        try {
            conn = ConnectionClass.getConnection();
        } catch (SQLException e) {
            LOGGER.error("SQLState: {} ErrorCode: {} Message: {}",
                    e.getSQLState(), e.getErrorCode(), e.getMessage());
        }
    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = new GetContactList(conn);
        command.execute(request, response);
    }
}
