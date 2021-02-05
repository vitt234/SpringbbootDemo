package com.example.demo.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Iterable<Student> findByNameAndPassword(String uname, String upass);

	public Student findById(int id);

	@Query("from Student")
	public List<Student> getData();

	@Transactional
	@Modifying
	@Query("update Student set name=:name,password=:pass where id=:id")

	public void updateData(String name, String pass, int id);

}
