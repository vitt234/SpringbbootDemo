package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServie {

	public Student add(Student s);

	public Iterable<Student> find();

	public List<Student> login(String uname, String upass);

	public Iterable<Student> deleteRecord(int id);

	public Student editRecord(int id);

	public Iterable<Student> updateRecord(Student e);

}
