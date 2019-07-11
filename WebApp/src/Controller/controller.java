package Controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.*;

import Model.*;


@WebServlet(name = "Controller")
public class controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        StringBuilder keyy=null,valuee=null;
        String v1 = request.getParameter("email");
        String v2 = request.getParameter("password");
        String v3 = request.getParameter("cpassword");
        String v4 = request.getParameter("act");
        String v5 = "";
        v5 = request.getParameter("act1");


        if (v4.equals("SignUp")) {
            String date11 = "";
            String last1 = "";
            String app1="";
            String key="";
            String value="";
            newuser r = new newuser();
            r.register(v1, v2);

            try {
                Connection conn;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");

                PreparedStatement p3;
                p3 = conn.prepareStatement
                        ("select * from details where Email=?");
                p3.setString(1, v1 );
                ResultSet r1 = p3.executeQuery();
                while (r1.next()) {
                    date11 = r1.getString("dateofsignup");
                    last1 = r1.getString("lastsign");
                    app1=r1.getString("lastsign1");
                   

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("userName1", v1);
            request.setAttribute("date", date11);
            request.setAttribute("l", last1);
            request.setAttribute("l1",app1);
            request.getRequestDispatcher("/UserAccount.jsp").forward(request, response);


        }

        if (v4.equals("SignOut")) {

            try {
                String m1 = request.getParameter("m");
                String m2 = request.getParameter("act1");
                if (m2.equals("del")) {
                    facade u1 = new facade();
                    u1.dell(m1);

                }

                request.setAttribute("us2", m1);
                request.getRequestDispatcher("/SignOut.jsp").forward(request, response);



            }
            catch (Exception e)
            {
                String m1 = request.getParameter("m");
                request.setAttribute("us2", m1);
                request.getRequestDispatcher("/SignOut.jsp").forward(request, response);
            }
        }

        if (v4.equals("SignIn")) {

            ResultSet resultSet = null;


            String date1 = "";
            String last = "";
            String app="";
            String key="";
            String value="";

            Check c= new Check();
            String val = c.checker(v1, v2);
            if (val.equals("SUCCESS")) {
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/project", "root1", "123");

                    PreparedStatement p2 = con.prepareStatement
                            ("select * from details where Email=?");
                    p2.setString(1, v1);
                    resultSet = p2.executeQuery();
                    while (resultSet.next()) {
                        date1 = resultSet.getString("dateofsignup");
                        last = resultSet.getString("lastsign");
                        app=resultSet.getString("lastsign1");
                 
             
                                 }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("userName1", v1);
                request.setAttribute("date", date1);
                request.setAttribute("l", last);
                request.setAttribute("l1",app);
             
                request.getRequestDispatcher("/UserAccount.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
            }
        }



        if (v4.equals("SignInAgain")) {

            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
        }



        if(v4.equals("Update"))

        {
            String o1 = request.getParameter("m");

            appdate a= new appdate();
            a.upd(o1);
            ResultSet resultSet1=null;
            String date111="";
            String last11="";
            String app11="";
            try {
                Connection con5;
                con5 = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project", "root1", "123");

                PreparedStatement p5 = con5.prepareStatement
                        ("select * from details where Email=?");
                p5.setString(1, o1);
                resultSet1 = p5.executeQuery();
                while (resultSet1.next()) {
                    date111 = resultSet1.getString("dateofsignup");
                    last11 = resultSet1.getString("lastsign");
                    app11=resultSet1.getString("lastsign1");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("userName1", o1);
            request.setAttribute("date", date111);
            request.setAttribute("l", last11);
            request.setAttribute("l1",app11);
            request.getRequestDispatcher("/UserAccount.jsp").forward(request,response);
        }
        /*if(v4.equals("Add"))
        {

            String o1 = request.getParameter("m");
            String k=request.getParameter("key");
            String v=request.getParameter("value");
            facade b=new facade();
            b.updkv(k,v,o1);
            ResultSet resultSet1=null;
            String date111="";
            String last11="";
            String app11="";
            String key="";
            String value="";
            try {
                Connection con5;
                con5 = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project", "root1", "123");

                PreparedStatement p5 = con5.prepareStatement
                        ("select * from details where Email=?");
                p5.setString(1, o1);
                resultSet1 = p5.executeQuery();
                while (resultSet1.next()) {
                    date111 = resultSet1.getString("dateofsignup");
                    last11 = resultSet1.getString("lastsign");
                    app11=resultSet1.getString("lastsign1");
                    key=resultSet1.getString("key1");
                    keyy = new StringBuilder(key);
                    keyy.deleteCharAt(0);

                    value=resultSet1.getString("value1");
                    valuee=new StringBuilder(value);
                    valuee.deleteCharAt(0);

                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("userName1", o1);
            request.setAttribute("date", date111);
            request.setAttribute("l", last11);
            request.setAttribute("l1",app11);
            request.setAttribute("k1",keyy);
            request.setAttribute("v1",valuee);

            request.getRequestDispatcher("/UserAccount.jsp").forward(request,response);


        }*/
        /*if(v4.equals("Remove"))
        {       String date111="";
            String last11="";
            String app11="";
            String key1="";
            String value1="";
            String key="",value="";
            String k=request.getParameter("key");
            String v=request.getParameter("value");
            ResultSet rr1,rr2;
            String o1 = request.getParameter("m");
            try {

                Connection cr;
                cr = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root1", "123");
                PreparedStatement pr1 = cr.prepareStatement("select * from details where Email=?");
                pr1.setString(1, o1);
                rr1 = pr1.executeQuery();
                while (rr1.next()) {
                    key = rr1.getString("key1");
                    value = rr1.getString("value1");


                }
                facade c = new facade();
                c.rem(key, value, k, v, o1);

                PreparedStatement p5 = cr.prepareStatement
                        ("select * from details where Email=?");
                p5.setString(1, o1);
                rr2 = p5.executeQuery();
                while (rr2.next()) {
                    date111 = rr2.getString("dateofsignup");
                    last11 = rr2.getString("lastsign");
                    app11 = rr2.getString("lastsign1");
                    key1 = rr2.getString("key1");
                    keyy = new StringBuilder(key1);
                    keyy.deleteCharAt(0);

                    value1 = rr2.getString("value1");
                    valuee = new StringBuilder(value1);
                    valuee.deleteCharAt(0);


                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("userName1", o1);
            request.setAttribute("date", date111);
            request.setAttribute("l", last11);
            request.setAttribute("l1",app11);
            request.setAttribute("k1",keyy);
            request.setAttribute("v1",valuee);

            request.getRequestDispatcher("/UserAccount.jsp").forward(request,response);
        }*/


    }


}