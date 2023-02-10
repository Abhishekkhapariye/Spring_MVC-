package ksolves.demospringmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.query.NativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
@Entity	
public class Employee  {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name",nullable = false)
    @NotEmpty(message="provide firstName!!")
    private String firstName;
    @NotEmpty(message="provide lastName!!")
    @Column(name = "last_name",unique=true,length=25)
    private String lastName;
    @Column(name = "email")
    @Email
    private String email;
    
    
}





