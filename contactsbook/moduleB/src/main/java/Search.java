import command.Command;
import command.SearchContacts;
import service.ConnectionClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Alexey on 03.04.2017.
 */
@WebServlet(name = "Search")
public class Search extends HttpServlet {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = new SearchContacts(conn);
        command.execute(request, response);
    }
}
