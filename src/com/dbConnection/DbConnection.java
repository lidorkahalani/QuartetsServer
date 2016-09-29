package com.dbConnection;

import java.sql.*;

public class DbConnection {
	static Connection con=null;

    /**
     * singleton method that will return connection to data base
     * @return Connection
     */
    public static Connection getConnection()
    {
        if (con != null) 
            return con;
        // get db, user, pass from settings file
        return getConnection(DbUtilitis.jdbcUrl, DbUtilitis.jdbcUser, DbUtilitis.jdbcPassword);
    }
    
    /**
     * this method create new connection to data base
     * 
     * @return Connection
     */
    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(db_name,user_name,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }

}
