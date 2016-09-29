package com.quartets;

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnection.DbConnection;
import com.google.gson.Gson;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//commit check
			String sql = "select * from users where user_name='"+request.getParameter("user_name")+"'and user_password='"+request.getParameter("user_password")+"'"; 
			PreparedStatement statement=DbConnection.getConnection().prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	User user=new User(resultSet.getString("user_name"), resultSet.getString("user_password"));
            	user.setUserId(resultSet.getInt("user_id"));
        		Gson gsonObj = new Gson();
        		String jsonList = gsonObj.toJson(user);
            	
            	response.setContentLength(jsonList.length());
            	response.getOutputStream().write(jsonList.getBytes());
            	response.getOutputStream().flush();
            	resultSet.close();		// close resultSet
                statement.close();	
            	break;
            }
            resultSet.close();		// close resultSet
            statement.close();		// close statement and resultSet
            //Connect_db.getConnection().close();		// close connection, statement and resultSet 	
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
