package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by Alexey on 17.03.2017.
 */
public class ConnectionClass {
    public static Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            FileInputStream in = new FileInputStream("moduleB\\resources\\connectionDB.properties");
        } catch (FileNotFoundException e) {
            System.out.println(".properties file not found");
        }
        com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource
                =new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("contact_book");
        dataSource.setPortNumber(3306);
        Connection con =dataSource.getConnection("root","11121314f");
        return con;
    }
}
