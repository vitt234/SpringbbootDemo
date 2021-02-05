package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.repositary.StudentRepository;
import com.example.demo.service.StudentServie;

@Controller
public class HomeController {

	@Autowired
	StudentServie ser;
	
	@Autowired
	StudentRepository repo;

	@RequestMapping("/")
	public String prelogin() {

		return "log";

	}

	@RequestMapping("/reg")
	public String preRegister() {

		return "register1";

	}

	@RequestMapping("/register")

	public String addUser(@ModelAttribute Student s, Model m) {

		Student student = ser.add(s);

		if (student == null) {
			String s1 = "<<<  Id is Already Present  >>>";
			
			System.out.println("hii this first demo project");

			m.addAttribute("msg", s1);

			return "register1";
		} else {
			return "log";
		}
	}

	@RequestMapping("/log")
	public String login(@RequestParam("name") String uname, @RequestParam("password") String upass, Model m) {

		Iterable<Student> elist = ser.login(uname, upass);

		System.out.println("login list::-" + elist);

		if (elist.equals("null")) {

			String s1 = "invalid credentials";

			m.addAttribute("msg", s1);
			return "log";

		} else {

			m.addAttribute("data", elist);

			return "success1";

		}

	}

	@RequestMapping("/delete")

	public String deleteData(@RequestParam("id") int id, Model m) {

		Iterable<Student> list = ser.deleteRecord(id);
		m.addAttribute("data", list);

		return "success1";

	}

	@RequestMapping("/edit")

	public String editData(@RequestParam("id") int id, Model m) {

		Student data = ser.editRecord(id);

		m.addAttribute("data", data);

		return "update1";

	}

	@RequestMapping("/update")

	public String updateData(@ModelAttribute("student") Student e, Model m) {

		Iterable<Student> list = ser.updateRecord(e);

		System.out.println("in update" + list);
		m.addAttribute("data", list);

		return "success1";

	}

	@RequestMapping("/sort")

	public String SortData(@RequestParam("sortvalue") int o, Model m) {

		List<Student> list = (List<Student>) ser.find();

		if (o == 1)

		{
			list.sort((o1, o2) -> o2.getId() - o1.getId());

			m.addAttribute("data", list);

			return "success1";
		} else if (o == 2)

		{
			list.sort(Comparator.comparing(Student::getName));

			m.addAttribute("data", list);

			return "success1";
		} else

		{
			list.sort(Comparator.comparing(Student::getAddress));

			m.addAttribute("data", list);

			return "success1";
		}

	}
	
	
	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		List<Student> allEmployees = repo.findAll();

		ByteArrayInputStream bis = Exportpdf.employeesReport(allEmployees);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=StudentInfo.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}


}
