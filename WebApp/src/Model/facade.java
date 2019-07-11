package Model;

import java.sql.*;

public class facade {
    public void register(String u, String p)
    {
        try {
            String kk="";
            String vv="";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
            PreparedStatement p1=con.prepareStatement("insert into details values (?,?,?,?,NOW(),NOW(),NOW()) ");
            p1.setString(1,u);
            p1.setString(2,p);
            p1.setString(3,kk);
            p1.setString(4,vv);

            p1.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    Statement statement = null;
    ResultSet resultSet = null;
    String user = "";
    String password = "";
    String date1="";

    public String checker(String userName, String pw) {
        try {


            Connection con3= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project","root1","123");
            statement = con3.createStatement();
            resultSet = statement.executeQuery("select * from details");
            while (resultSet.next())
            {
                user = resultSet.getString("Email");
                password = resultSet.getString("password");
                date1 = resultSet.getString("dateofsignup");
                if (userName.equals(user) && pw.equals(password)) {
                    PreparedStatement p3=con3.prepareStatement
                            ("update details set lastsign = NOW() where Email =?");
                    p3.setString(1, userName );
                    p3.executeUpdate();

                    return "SUCCESS";
                }

            }



        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid Details!!!";

    }

    public void dell(String u)
    {
        try {
            Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
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

    public void updkv(String k,String v,String u)
    {
        try {
            Connection conk = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
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

    public void rem(String k, String v, String k1, String v1, String u) {
        try {
            String k2=k.replace(","+k1,"");
            String v2=v.replace(","+v1,"");
            Connection conr = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
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
