package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@NamedQuery(name = "logdata", query = "from Student where name=:name and password=:pass")

@Table(name = "Student_jpa")
public class Student {
	@Id
	private int id;

	private String name;

	private String password;

	private String address;

	private String mobno;

	private String email;

}
