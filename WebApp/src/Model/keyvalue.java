package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class keyvalue {

    public void updkv(String k,String v,String u)
    {
        try {
            Connection conk = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "1234");
            PreparedStatement pk=conk.prepareStatement("update details set key1=CONCAT(key1,?,?),value1=CONCAT(value1,?,?) where Email=?");
            pk.setString(1,",");
            pk.setString(2,k);
            pk.setString(3,",");
            pk.setString(4,v);
            pk.setString(5,u);

            pk.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
