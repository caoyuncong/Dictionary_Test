/*import com.mysql.jdbc.Driver;

import java.sql.*;

*//**
 * Created by Administrator on 2017/2/17.
 *//*
public class MetaDataTest {
    public static void main(String[] args) throws SQLException {
        new Driver();
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db_user_book?user=root?password=system");
        DatabaseMetaData databaseMetaData=connection.getMetaData();

        System.out.println(databaseMetaData.getDriverName());
        System.out.println(databaseMetaData.getDriverVersion());

        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseMajorVersion());
        System.out.println(databaseMetaData.getDatabaseMinorVersion());

        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"table"});
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }
    }
}*/
