package com.blog.models.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserRoleRepo {
  
  private Connection dbConnect;
  private String dbDriver = "com.mysql.jdbc.Driver";
  private String dbUrl = "jdbc:mysql://localhost/spring-blog";
  private String dbUsername = "root";
  private String dbPass = "";

  // Connect to database
  private void connect() {
		try {
			Class.forName(dbDriver);
			dbConnect = DriverManager.getConnection(dbUrl, dbUsername, dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
  // Disconnect from database
	private void disconnect() {
		try {
			if (dbConnect != null) {
				dbConnect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  // get role based on user_id
  
  public ArrayList<Integer> findRoleWithUserID(Long userId) {
    ArrayList<Integer> roleId = new ArrayList<Integer>();

    try {
      connect();

      String sql = "SELECT * FROM user_role where user_id = ?";
      
      PreparedStatement ps = dbConnect.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        roleId.add(Integer.valueOf(rs.getString("role_id")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    disconnect();

    return roleId;
  }

  // public Iterable<Role> findRoles(Long userId) {
  //   ArrayList<Role> roles = new ArrayList<Role>();

  //   ArrayList<Integer> rolesId = findRoleWithUserID(userId);

  //   String sql = "SELECT * FROM "
  //   try {
  //     connect();
  //   }
  // }
  
}