import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Administrator on 2017/2/17.
 */
public class DumpData {
    private static final String FILE_NAME = "e:/CET_4.txt";
    private static final String URL = "jdbc:mysql:///db_dictionary?user=root&password=system";
    public static void main(String[] args) throws SQLException {
        new Driver();
        Connection connection= DriverManager.getConnection(URL);
        String sql = "INSERT INTO db_dictionary.lemma VALUE (NULL ,?,NULL ,NULL ,NULL ,NULL ,DEFAULT )";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                preparedStatement.setString(1,line);
            }
                preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
