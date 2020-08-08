package ua.alvin.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String user = "springstudent";
//            String password = "springstudent";
//            String URL =
//                    "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
//            System.out.println(22222222);
//
//
//            PrintWriter printWriter = response.getWriter();
//            printWriter.println("Connecting to: " + URL);
//            Connection connection = DriverManager.getConnection(URL,user,password);
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

    }
}
