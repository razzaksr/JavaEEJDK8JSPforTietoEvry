import oracle.jdbc.driver.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String query="select * from hai where id=?";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,Integer.parseInt(request.getParameter("id")));
            ResultSet resultSet=preparedStatement.executeQuery();
            Hai hai=null;
            if(resultSet.next()){
                hai=new Hai();
                hai.setId(resultSet.getInt("id"));
                hai.setName(resultSet.getString("name"));
                hai.setPrice(resultSet.getInt("price"));
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");
            request.setAttribute("single",hai);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
