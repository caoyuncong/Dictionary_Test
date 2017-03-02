import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Administrator on 2017/2/17.
 */
public class DdlTest {
    public static void main(String[] args) throws SQLException {
        new Driver();
        Connection connection = DriverManager.getConnection("jdbc:mysql:///", "root", "system");
        String sql="CREATE DATABASE db_ddl";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        String tableSql="CREATE TABLE db_ddl.test(id INT)";
        preparedStatement=connection.prepareStatement(tableSql);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
        System.out.println("done...");

    }
}
