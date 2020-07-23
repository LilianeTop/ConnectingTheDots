package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DBAccess {
    /* public static DBAccess getDBAccess() {
        if (database == null) {
            database = new DBAccess("ConnectingTheDots", "userConnectingTheDots", "pwConnectingTheDots");
        }
        return database;
    }*/

    private Connection connection;
    private static final String DATABASE_NAME = "ConnectingTheDots";
    private static final String MAIN_USER = "userConnectingTheDots";
    private static final String MAIN_USER_PASSWORD = "pwConnectingTheDots";
    private static final String SQL_EXCEPTION = "SQL Exception: ";
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PREFIX_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String CONNECTION_SETTINGS = "?useSSL=false" +
            "&allowPublicKeyRetrieval=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";

   /* public DBAccess(String databaseName, String mainUser, String mainUserPassword) {
        super();

    }*/

    public DBAccess() {
        super();
    }

    /**
     * Open database connection
     */
    public void openConnection() {
        String connectionURL = PREFIX_CONNECTION_URL + DATABASE_NAME + CONNECTION_SETTINGS;
        try {
            System.out.print("Load the driver... ");
            Class.forName(MYSQL_DRIVER); // laad de JDBC-driver.
            System.out.println("Driver loaded");

            connection = DriverManager.getConnection(connectionURL, MAIN_USER, MAIN_USER_PASSWORD);
            System.out.println("OK, Connection open");
        } catch (ClassNotFoundException driverFout) {
            System.out.println("Driver not found");
        } catch (SQLException sqlFout) {
            System.out.println(SQL_EXCEPTION + sqlFout.getMessage());
        }
    }

    /**
     * Close database connection
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception connectionFout) {
            System.err.println(connectionFout.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            this.openConnection();
        }
        try {
            if (connection.isClosed()) {
                this.openConnection();
            }
        }
        catch (SQLException sqlFout) {
            System.out.println("connection error");
        }
        return connection;
    }
}
