package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class remove {
    public void rem(String k, String v, String k1, String v1, String u) {
        try {
            String k2=k.replace(","+k1,"");
            String v2=v.replace(","+v1,"");
            Connection conr = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false", "root1", "1234");
            PreparedStatement pr = conr.prepareStatement("update details set key1=?,value1=? where Email=?");
            pr.setString(1,k2);
            pr.setString(2,v2);
            pr.setString(3,u);
            pr.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
