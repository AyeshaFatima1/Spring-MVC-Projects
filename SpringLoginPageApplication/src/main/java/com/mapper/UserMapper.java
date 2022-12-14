package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.User;

public class UserMapper implements RowMapper<User> {

	    public static final String BASE_SQL //
	            = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u ";

	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

	        Long userId = rs.getLong("User_Id");
	        String userName = rs.getString("User_Name");
	        String encrytedPassword = rs.getString("Encryted_Password");

	        return new User(userId, userName, encrytedPassword);
	    }

	}
