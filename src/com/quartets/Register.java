package com.quartets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnection.DbConnection;
import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String respons="";
	String userName=request.getParameter("user_name");
	String password=request.getParameter("user_password");
		String sql="insert into users (user_name,user_password) values(?,?)";
		
		try {
			PreparedStatement ps=(PreparedStatement) DbConnection.getConnection().prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2,password);
			int res = ps.executeUpdate();
			if (res > 0) {
				respons="sucsses";
			}
			else{
				respons="sucsses";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Gson gsonObj = new Gson();
    		String jsonList = gsonObj.toJson(respons);
			response.setContentLength(jsonList.length());
        	response.getOutputStream().write(jsonList.getBytes());
        	response.getOutputStream().flush();
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
