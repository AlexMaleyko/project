package service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by Alexey on 17.03.2017.
 */
public class ConnectionClass {
    private static final org.slf4j.Logger LOGGER=
            org.slf4j.LoggerFactory.getLogger(ContactController.class);
    public static Connection getConnection() throws SQLException {

       Connection conn = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/contactBook");
            conn = ds.getConnection();
        } catch (NamingException e) {
            LOGGER.error("{} {}", e.getClass().getSimpleName(), e.getMessage());
        }
        return conn;
    }
}
