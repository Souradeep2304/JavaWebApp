package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newuser {


    public void register(String u, String p)
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
            PreparedStatement p1=con.prepareStatement("insert into details values (?,?,NOW(),NOW(),NOW()) ");
            p1.setString(1,u);
            p1.setString(2,p);
            p1.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
