package com.quartets;

public class User {
	  private String userName;
	    private String password;
	    private int score=0;
	    private int userId;



	    public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public User(String userName,String password) {
	        setUserName(userName);
	        setPassword(password);
	    }
		
		public User(String userName, String password,int id) {
	        setUserName(userName);
	        setPassword(password);
	        setUserId(id);
	    }


	    public int getScore() {
	        return score;
	    }

	    public void setScore(int score) {
	        this.score = score;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "userName='" + getUserName() + '\'' +
	                ", password='" + getPassword() + '\'' +
	                ", Score='" + getScore() + '\'' +
	                '}';
	    }

}
