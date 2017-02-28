package main.domain;

/**
 *
 * @author Idorf
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper {


	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCustomerType(rs.getInt("customer_type_id"));
        customer.setCustomerName(rs.getString("customer_name"));
        customer.setCity(rs.getString("city"));
        customer.setAddressLine1StreetName(rs.getString("line1_street_name"));
        customer.setAddressLine2StreetNo(rs.getString("line2_street_no"));
        customer.setAddressLine3BuildingNo(rs.getString("line_3_building_no"));
        customer.setZipcode(rs.getInt("zipcode"));
        customer.setOtherAdressDetails(rs.getString("other_address_details"));
        return customer;
    }
}
