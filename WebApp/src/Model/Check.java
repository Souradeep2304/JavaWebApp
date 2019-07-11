package Model;

import java.sql.*;


public class Check {

    Statement statement = null;
    ResultSet resultSet = null;
    String user = "";
    String password = "";
    String date1="";

    public String checker(String userName, String pw) {
        try {


            Connection con3= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false","root1","123");
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
}




