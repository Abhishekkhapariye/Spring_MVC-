/*package rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ksolves.demospringmvc.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int i) throws SQLException {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.setId(rs.getInt(i));
		e.setFirstName(rs.getString("firstName"));
		e.setLastName(rs.getString("lastName"));
		e.setEmail(rs.getString("email"));
		return e;
	}
	

}*/

