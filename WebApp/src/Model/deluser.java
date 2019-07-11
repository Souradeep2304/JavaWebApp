package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deluser {


    public void dell(String u)
    {
        try {
            Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false", "root1", "123");
            PreparedStatement p4 = con4.prepareStatement("delete from details where Email=?");
            p4.setString(1,u);
            p4.execute();
            con4.close();


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
