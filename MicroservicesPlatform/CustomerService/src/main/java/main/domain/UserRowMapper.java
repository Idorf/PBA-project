/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.domain;

/**
 *
 * @author Idorf
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserID(rs.getInt("user_id"));
		user.setCustomerId(1);
		user.setUserType(rs.getInt("role_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setTelephoneNo(rs.getInt("telephone_no"));
		return user;
	}
}
