package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repositary.StudentRepository;
import com.example.demo.service.StudentServie;

@Service
public class StudentServiceImpl implements StudentServie {

	@Autowired

	StudentRepository repo;

	@Override
	public Student add(Student s) {

		System.out.println(s);

		boolean flag = true;

		try {

			if (flag) {
				Student s1 = editRecord(s.getId());

				if (s1.getId() == s.getId()) {

					return null;
				}

			}

		} catch (NullPointerException e11) {
			{

				Student stu = repo.save(s);

				return stu;

			}
		}
		return null;

	}

	@Override
	public Iterable<Student> find() {

		Iterable<Student> all = repo.getData();

		return all;
	}

	@Override
	public List<Student> login(String uname, String upass) {

		if (uname.equalsIgnoreCase("admin") && upass.equalsIgnoreCase("admin")) {
			return repo.findAll();

		} else {

			return repo.findByNameAndPassword(uname, upass);
		}
	}

	@Override
	public Iterable<Student> deleteRecord(int id) {
		repo.deleteById(id);
		return find();
	}

	@Override
	public Student editRecord(int id) {

		Student stu = repo.findById(id);
		return stu;
	}

	@Override
	public Iterable<Student> updateRecord(Student e) {

		repo.updateData(e.getName(), e.getPassword(), e.getId());

		System.out.println("data::" + e.getId() + " " + e.getName() + " " + e.getPassword());
		return find();
	}

}
