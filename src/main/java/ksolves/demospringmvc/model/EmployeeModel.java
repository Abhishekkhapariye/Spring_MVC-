package ksolves.demospringmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EmployeeModel {

	
	
	private Integer id;
	public String firstName;
	private String lastName;
	private String email;
	
	
}
