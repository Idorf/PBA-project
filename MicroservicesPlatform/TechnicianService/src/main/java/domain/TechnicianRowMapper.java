/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Idorf
 */    
public class TechnicianRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Technician technician = new Technician();
                technician.setTechnicianId(rs.getInt("technician_id"));
		technician.setFirstName(rs.getString("first_name"));
		technician.setLastName(rs.getString("last_name"));
		technician.setEmployeId(rs.getInt("employe_id"));

		return technician;
	}
}