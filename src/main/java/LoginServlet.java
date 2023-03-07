import oracle.jdbc.driver.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/authenticate")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver = new OracleDriver();
            ServletContext obj = request.getServletContext();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
            String query = "select * from bankers where banker_id=? and banker_passcode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(request.getParameter("bankerId")));
            preparedStatement.setString(2, request.getParameter("bankerPin"));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                HttpSession hp=request.getSession();
                hp.setAttribute("user",resultSet.getString("banker_name"));
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        }
        catch(SQLException sqls){

        }
    }
}
