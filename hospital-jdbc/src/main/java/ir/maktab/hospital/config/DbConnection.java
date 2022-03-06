package ir.maktab.hospital.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @deprecated Better to use Datasource instead of DriverManager to get Connection
 */
@Deprecated(forRemoval = true)
public class DbConnection {

    private DbConnection() {
    }

    public static Connection createConnection() {

        try {
            Class.forName(DbConfig.DRIVER);
            Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USERNAME, DbConfig.PASSWORD);
            System.out.println("connected");
            return connection;

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("classNotFoundException");
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        } catch (Exception exception) {
            System.out.println("exception");
        }

        return null;
    }

}
